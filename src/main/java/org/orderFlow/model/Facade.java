package org.orderFlow.model;

import org.orderFlow.controller.ControladorMesas;
import org.orderFlow.interfaces.IVistaMesas;
import org.orderFlow.model.UPP.TipoUnidadProcesadoraPedidos;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.List;

/**
 * Clase fachada que maneja la lógica de negocio.
 * Utiliza el patrón Singleton para garantizar que solo haya una instancia de la fachada.
 */
public class Facade extends Observable {

    private static Facade instancia = new Facade();

    /**
     * Devuelve la instancia única de la fachada.
     *
     * @return La instancia de Facade.
     */
    public static Facade Instancia() {
        return instancia;
    }

    private Facade() {}

    private ArrayList<Observer> observadores = new ArrayList<>();
    private SMesas smesas = new SMesas();
    private SUPPs supps = new SUPPs();
    private SUsuarios susuarios = new SUsuarios();

    /**
     * Devuelve el servicio de mesas.
     *
     * @return El servicio de mesas.
     */
    public SMesas getSmesas() {
        return smesas;
    }

    /**
     * Devuelve el servicio de unidades procesadoras de pedidos.
     *
     * @return El servicio de unidades procesadoras de pedidos.
     */
    public SUPPs getSupps() {
        return supps;
    }

    /**
     * Devuelve el servicio de usuarios.
     *
     * @return El servicio de usuarios.
     */
    public SUsuarios getSusuarios() {
        return susuarios;
    }

    /**
     * Devuelve la lista de observadores.
     *
     * @return La lista de observadores.
     */
    public ArrayList<Observer> getObservadores() {
        return observadores;
    }

    /**
     * Agrega un observador.
     *
     * @param o El observador a agregar.
     */
    public void agregarObserver(Observer o) {
        this.observadores.add(o);
    }

    /**
     * Maneja el proceso de inicio de sesión.
     *
     * @param user El nombre de usuario.
     * @param pass La contraseña del usuario.
     * @return El mensaje de resultado del login.
     */
    public String login(String user, String pass) {
        return susuarios.login(user, pass);
    }

    /**
     * Maneja el proceso de cierre de sesión.
     *
     * @param user El nombre de usuario.
     * @return El mensaje de resultado del logout.
     */
    public String logout(String user) {
        Usuario u = buscarUsuario(user);
        String resultado = susuarios.logout(u);
        if (resultado.equals(Constantes.Msg_User_Logout)) {
            notificar();
        }
        return resultado;
    }

    /**
     * Agrega un nuevo usuario.
     *
     * @param nombre El nombre del usuario.
     * @param user El nombre de usuario.
     * @param pass La contraseña del usuario.
     * @param tipo El tipo de usuario.
     */
    public void agregarUsuario(String nombre, String user, String pass, String tipo) {
        susuarios.crear(nombre, user, pass, tipo);
    }

    /**
     * Devuelve la lista de todos los usuarios.
     *
     * @return La lista de usuarios.
     */
    public List<Usuario> listaUsuarios() {
        return susuarios.getListUsers();
    }

    /**
     * Devuelve la lista de usuarios logueados.
     *
     * @return La lista de usuarios logueados.
     */
    public List<Usuario> listaLogeados() {
        return susuarios.getListLogeados();
    }

    /**
     * Devuelve la lista de mozos logueados gestionados por un mozo.
     *
     * @param mozo El usuario mozo.
     * @return La lista de mozos logueados.
     */
    public List<Usuario> listaMozosLogeados(Usuario mozo) {
        return susuarios.getListMozosLogeados(mozo);
    }

    /**
     * Busca un usuario por su nombre de usuario.
     *
     * @param user El nombre de usuario.
     * @return El usuario encontrado.
     */
    public Usuario buscarUsuario(String user) {
        return susuarios.getUsuario(user);
    }

    /**
     * Agrega una nueva mesa.
     *
     * @param numero El número de la mesa.
     * @return true si la mesa fue agregada con éxito, false en caso contrario.
     */
    public boolean agregarMesa(int numero) {
        return smesas.agregarMesa(numero);
    }

    /**
     * Devuelve la lista de todas las mesas.
     *
     * @return La lista de mesas.
     */
    public ArrayList<Mesa> listaMesas() {
        return (ArrayList<Mesa>) smesas.getMesas();
    }

    /**
     * Busca una mesa por su número.
     *
     * @param numero El número de la mesa.
     * @return La mesa encontrada.
     */
    public Mesa buscarMesa(int numero) {
        return smesas.getMesa(numero);
    }

    /**
     * Devuelve la lista de todas las unidades procesadoras de pedidos.
     *
     * @return La lista de unidades procesadoras de pedidos.
     */
    public List<UPP> listaUPPs() {
        return supps.getUnidadesProcesadoraPedidos();
    }

    /**
     * Busca una unidad procesadora de pedidos por su tipo.
     *
     * @param tipo El tipo de unidad procesadora de pedidos.
     * @return La unidad procesadora de pedidos encontrada.
     */
    public UPP buscarUpp(TipoUnidadProcesadoraPedidos tipo) {
        return supps.buscarUPP(tipo);
    }

    /**
     * Toma un pedido.
     *
     * @param pedido El pedido.
     * @param gestor El usuario que gestiona el pedido.
     * @param upp La unidad procesadora de pedidos.
     * @return true si el pedido fue tomado con éxito, false en caso contrario.
     */
    public boolean tomarPedido(ItemPedido pedido, Usuario gestor, UPP upp) {
        return supps.tomarPedido(pedido, gestor, upp);
    }

    /**
     * Finaliza un pedido.
     *
     * @param pedido El pedido.
     * @return true si el pedido fue finalizado con éxito, false en caso contrario.
     */
    public boolean finalizarPedido(ItemPedido pedido) {
        return supps.finalizarPedido(pedido);
    }

    /**
     * Devuelve la lista de todos los productos.
     *
     * @return La lista de productos.
     */
    public ArrayList<Producto> listaProductos() {
        return (ArrayList<Producto>) smesas.getProductos();
    }

    /**
     * Abre una mesa.
     *
     * @param mesa La mesa a abrir.
     * @return true si la mesa fue abierta con éxito, false en caso contrario.
     */
    public boolean abrirMesa(Mesa mesa) {
        return smesas.abrirMesa(mesa);
    }

    /**
     * Cierra una mesa.
     *
     * @param mesa La mesa a cerrar.
     * @return true si la mesa fue cerrada con éxito, false en caso contrario.
     */
    public boolean cerrarMesa(Mesa mesa) {
        return smesas.cerrarMesa(mesa);
    }

    /**
     * Notifica cambios en las mesas.
     */
    public void notificarMesas() {
        smesas.notificar();
    }

    /**
     * Notifica cambios en todas las mesas.
     */
    public void notificarTodasMesas() {
        smesas.notificarMesas();
    }

    /**
     * Devuelve la lista de mesas gestionadas por un mozo.
     *
     * @param user El nombre de usuario del mozo.
     * @return La lista de mesas gestionadas por el mozo.
     */
    public ArrayList<Mesa> listaMesasMozo(String user) {
        Usuario u = susuarios.getUsuario(user);
        return (ArrayList<Mesa>) smesas.mesasDeMozo(u);
    }

    /**
     * Devuelve la lista de tipos de unidades procesadoras de pedidos.
     *
     * @return La lista de tipos de unidades procesadoras de pedidos.
     */
    public List<TipoUnidadProcesadoraPedidos> getEnumerado() {
        return supps.listadoTipoUnidad();
    }

    /**
     * Solicita la transferencia de una mesa a otro mozo.
     *
     * @param mesa La mesa a transferir.
     * @param mozoOrigen El mozo que transfiere la mesa.
     * @param mozoDestino El mozo que recibe la mesa.
     */
    public void askTransferirMesa(Mesa mesa, Usuario mozoOrigen, Usuario mozoDestino) {
        IVistaMesas vgm = buscarVGM(mozoDestino);
        vgm.notificarTransferencia(mozoOrigen, mesa);
    }

    /**
     * Responde a una solicitud de transferencia de mesa.
     *
     * @param respuesta La respuesta a la solicitud (aceptar o rechazar).
     * @param mozoOrigen El mozo que transfiere la mesa.
     */
    public void responderTransferencia(int respuesta, Usuario mozoOrigen) {
        IVistaMesas vgm = buscarVGM(mozoOrigen);
        vgm.transferir(respuesta);
    }

    /**
     * Busca la vista de gestión de mesas correspondiente a un mozo.
     *
     * @param mozo El usuario del mozo.
     * @return La vista de gestión de mesas encontrada.
     */
    public IVistaMesas buscarVGM(Usuario mozo) {
        boolean encontrado = false;
        IVistaMesas vgi = null;
        ControladorMesas cm = null;
        boolean cast = false;
        int i = 0;
        while (i < observadores.size() && !encontrado) {
            try {
                cm = (ControladorMesas) observadores.get(i);
                vgi = (IVistaMesas) cm.getVista();
                cast = true;
            } catch (Exception e) {
                cast = false;
            }
            if (cast && vgi.getMozo() == mozo) {
                encontrado = true;
            }
            i++;
        }
        if (!encontrado) {
            vgi = null;
        }
        return vgi;
    }

    /**
     * Transfiere una mesa a otro mozo.
     *
     * @param mesa La mesa a transferir.
     * @param mozo El mozo que recibe la mesa.
     * @return true si la mesa fue transferida con éxito, false en caso contrario.
     */
    public boolean transferirMesa(Mesa mesa, Usuario mozo) {
        return smesas.agregarMozo(mozo, mesa);
    }

    /**
     * Agrega un ítem a un servicio.
     *
     * @param mesa La mesa.
     * @param producto El producto a agregar.
     * @param cantidad La cantidad del producto.
     * @param comentario Comentarios adicionales.
     * @param mozo El mozo que agrega el ítem.
     */
    public void agregarItemServicio(Mesa mesa, Producto producto, int cantidad, String comentario, Usuario mozo) {
        supps.agregarItemPedido(mesa, producto, cantidad, comentario, mozo);
        smesas.reducirStock(producto, cantidad);
    }

    /**
     * Agrega un observador para las unidades procesadoras de pedidos.
     *
     * @param o El observador a agregar.
     */
    public void agregarObserverSUPP(Observer o) {
        supps.agregarObserver(o);
    }

    /**
     * Notifica la finalización de un pedido.
     *
     * @param item El ítem del pedido.
     */
    public void notificarPedidoFinalizado(ItemPedido item) {
        IVistaMesas vgi = buscarVGM(item.getMozo());
        vgi.notificarPedido(item);
    }

    /**
     * Notifica a todos los observadores.
     */
    public void notificar() {
        for (Observer o : observadores) {
            o.update(this, null);
        }
    }

    /**
     * Busca un cliente por su ID.
     *
     * @param id El ID del cliente.
     * @return El cliente encontrado.
     */
    public ICliente buscarCliente(int id) {
        return susuarios.buscarCliente(id);
    }

    /**
     * Registra un nuevo cliente.
     *
     * @param nombre El nombre del cliente.
     * @param email El email del cliente.
     * @param tipo El tipo de cliente.
     * @return true si el cliente fue registrado con éxito, false en caso contrario.
     */
    public boolean registrarCliente(String nombre, String email, String tipo) {
        return susuarios.registrarCliente(nombre, email, tipo);
    }

    /**
     * Busca un producto por su código.
     *
     * @param codigo El código del producto.
     * @return El producto encontrado.
     */
    public Producto buscarProducto(String codigo) {
        return smesas.buscarProducto(codigo);
    }

    /**
     * Busca un producto por su OID.
     *
     * @param oid El OID del producto.
     * @return El producto encontrado.
     */
    public Producto buscarProducto(int oid) {
        return smesas.buscarProducto(oid);
    }

    /**
     * Verifica si un mozo tiene mesas abiertas.
     *
     * @param mozo El usuario del mozo.
     * @return true si el mozo tiene mesas abiertas, false en caso contrario.
     */
    public boolean mesasAbiertasMozo(Usuario mozo) {
        return smesas.mesasAbiertasMozo(mozo);
    }

    /**
     * Carga una lista de productos.
     *
     * @param productos La lista de productos a cargar.
     */
    public void cargarProductos(ArrayList<Producto> productos) {
        smesas.cargarProductos(productos);
    }

    /**
     * Carga una lista de clientes.
     *
     * @param clientes La lista de clientes a cargar.
     */
    public void cargarClientes(ArrayList<ICliente> clientes) {
        susuarios.cargarClientes(clientes);
    }
}
