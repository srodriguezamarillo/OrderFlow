package org.orderFlow.model;

import org.orderFlow.mapper.MapeadorClienteComun;
import org.orderFlow.persistence.Persistencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Clase que gestiona los usuarios y clientes del sistema.
 */
@Service
public class SUsuarios {

    public enum TipoCliente {COMUN, PREFERENCIAL, DELACASA}

    private List<Usuario> usuarios = new ArrayList<>();
    private List<Usuario> logeados = new ArrayList<>();
    private List<ICliente> clientes = new ArrayList<>();
    Persistencia persistencia = Persistencia.Instancia();

    @Autowired
    private MapeadorClienteComun mapeadorClienteComun;

    /**
     * Crea un nuevo usuario en el sistema.
     *
     * @param nombre El nombre del usuario.
     * @param user El nombre de usuario.
     * @param pass La contraseña del usuario.
     * @param tipo El tipo de usuario (Mozo o Gestor).
     * @return true si el usuario se creó con éxito, false en caso contrario.
     */
    public boolean crear(String nombre, String user, String pass, String tipo) {
        if (usuarios.stream().anyMatch(u -> u.getUser().equals(user))) {
            return false;
        }

        try {
            if (tipo.equals("Mozo")) {
                new Usuario(nombre, user, pass, Usuario.TipoUser.MOZO);
            } else if (tipo.equals("Gestor")) {
                new Usuario(nombre, user, pass, Usuario.TipoUser.GESTOR);
            } else {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Modifica un usuario existente en el sistema.
     *
     * @param nombre El nuevo nombre del usuario.
     * @param user El nombre de usuario.
     * @param pass La nueva contraseña del usuario.
     * @return true si el usuario se modificó con éxito, false en caso contrario.
     */
    public boolean modificar(String nombre, String user, String pass) {
        Usuario u = getUsuario(user);

        if (u != null) {
            try {
                u.setNombre(nombre);
                u.setPass(pass);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    /**
     * Elimina un usuario del sistema.
     *
     * @param user El nombre de usuario.
     * @return true si el usuario se eliminó con éxito, false en caso contrario.
     */
    public boolean eliminar(String user) {
        Usuario u = getUsuario(user);

        if (u != null) {
            try {
                usuarios.remove(u);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    /**
     * Devuelve un usuario por su nombre de usuario.
     *
     * @param user El nombre de usuario.
     * @return El usuario encontrado o null si no se encuentra.
     */
    public Usuario getUsuario(String user) {
        return usuarios.stream().filter(u -> u.getUser().equals(user)).findFirst().orElse(null);
    }

    /**
     * Devuelve la lista de todos los usuarios.
     *
     * @return La lista de todos los usuarios.
     */
    public List<Usuario> getListUsers() {
        return usuarios;
    }

    /**
     * Devuelve la lista de usuarios logeados.
     *
     * @return La lista de usuarios logeados.
     */
    public List<Usuario> getListLogeados() {
        return logeados;
    }

    /**
     * Devuelve la lista de clientes.
     *
     * @return La lista de clientes.
     */
    public List<ICliente> getClientes() {
        return clientes;
    }

    /**
     * Realiza el login de un usuario en el sistema.
     *
     * @param user El nombre de usuario.
     * @param pass La contraseña del usuario.
     * @return Un mensaje de éxito o error del login.
     */
    public String login(String user, String pass) {
        Usuario usuario = getUsuario(user);

        if (usuario == null) {
            return Constantes.Msg_User_NoExiste;
        }

        if (!usuario.getPass().equals(pass)) {
            return Constantes.Msg_User_Credenciales;
        }

        if (logeados.contains(usuario)) {
            return Constantes.Msg_User_Logeado;
        }

        logeados.add(usuario);
        return Constantes.Msg_User_Correcto;
    }

    /**
     * Realiza el logout de un usuario del sistema.
     *
     * @param user El usuario a desloguear.
     * @return Un mensaje de éxito o error del logout.
     */
    public String logout(Usuario user) {
        try {
            logeados.remove(user);
            return Constantes.Msg_User_Logout;
        } catch (Exception e) {
            return Constantes.Msg_User_ErrorLogout;
        }
    }

    /**
     * Devuelve la lista de mozos logeados excluyendo al mozo especificado.
     *
     * @param mozo El mozo a excluir.
     * @return La lista de mozos logeados.
     */
    public List<Usuario> getListMozosLogeados(Usuario mozo) {
        List<Usuario> retorno = new ArrayList<>();
        for (Usuario u : logeados) {
            if (u.getClass() == mozo.getClass() && u != mozo) {
                retorno.add(u);
            }
        }
        return retorno;
    }

    /**
     * Busca un cliente por su ID.
     *
     * @param id El ID del cliente.
     * @return El cliente encontrado o null si no se encuentra.
     */
    public ICliente buscarCliente(int id) {
        Optional<ClienteComun> clienteComun = mapeadorClienteComun.findById(id);
        return clienteComun.orElse(null);
    }

    /**
     * Registra un nuevo cliente en el sistema.
     *
     * @param nombre El nombre del cliente.
     * @param email El email del cliente.
     * @param tipo El tipo de cliente.
     * @return true si el cliente se registró con éxito, false en caso contrario.
     */
    public boolean registrarCliente(String nombre, String email, String tipo) {
        switch (TipoCliente.valueOf(tipo)) {
            case COMUN:
                new ClienteComun(nombre, email);
                break;
            case PREFERENCIAL:
                new ClientePreferencial(nombre, email);
                break;
            case DELACASA:
                new ClienteDeLaCasa(nombre, email);
                break;
            default:
                return false;
        }
        return true;
    }

    /**
     * Carga una lista de clientes en el sistema.
     *
     * @param clientes La lista de clientes a cargar.
     */
    public void cargarClientes(List<ICliente> clientes) {
        this.clientes.addAll(clientes);
    }
}
