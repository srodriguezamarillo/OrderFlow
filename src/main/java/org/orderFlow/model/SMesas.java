package org.orderFlow.model;

import org.orderFlow.persistence.Persistencia;
import org.orderFlow.mapper.MapeadorItemPedido;
import org.orderFlow.mapper.MapeadorProducto;
import org.orderFlow.mapper.MapeadorServicio;
import org.orderFlow.model.UPP.TipoUnidadProcesadoraPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Clase que gestiona las operaciones relacionadas con las mesas y los productos.
 */
@Service
public class SMesas extends Observable {

    private List<Mesa> mesas = new ArrayList<>();
    private List<Producto> productos = new ArrayList<>();
    private List<Observer> observadores = new ArrayList<>();
    Persistencia persistencia = Persistencia.Instancia();

    @Autowired
    private MapeadorServicio mapeadorServicio;

    @Autowired
    private MapeadorItemPedido mapeadorItemPedido;

    /**
     * Devuelve la lista de mesas.
     *
     * @return La lista de mesas.
     */
    public List<Mesa> getMesas() {
        return mesas;
    }

    /**
     * Devuelve la lista de productos.
     *
     * @return La lista de productos.
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * Agrega una nueva mesa.
     *
     * @param numero El número de la mesa.
     * @return true si la mesa se agregó con éxito, false en caso contrario.
     */
    public boolean agregarMesa(int numero) {
        if (mesas.stream().anyMatch(m -> m.getNumero() == numero)) {
            return false;
        }

        try {
            Mesa m = new Mesa(numero);
            mesas.add(m);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Asigna un mozo a una mesa.
     *
     * @param mozo El mozo a asignar.
     * @param mesa La mesa a la que se asigna el mozo.
     * @return true si la asignación fue exitosa, false en caso contrario.
     */
    public boolean agregarMozo(Usuario mozo, Mesa mesa) {
        try {
            mesa.setMozo(mozo);
            notificar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Devuelve la mesa con el número especificado.
     *
     * @param numero El número de la mesa.
     * @return La mesa encontrada o null si no se encuentra.
     */
    public Mesa getMesa(int numero) {
        return mesas.stream().filter(m -> m.getNumero() == numero).findFirst().orElse(null);
    }

    /**
     * Devuelve el producto con el código especificado.
     *
     * @param codigo El código del producto.
     * @return El producto encontrado o null si no se encuentra.
     */
    public Producto getProducto(String codigo) {
        return productos.stream().filter(p -> p.getCodigo().equals(codigo)).findFirst().orElse(null);
    }

    /**
     * Abre una mesa.
     *
     * @param mesa La mesa a abrir.
     * @return true si la mesa se abrió con éxito, false en caso contrario.
     */
    public boolean abrirMesa(Mesa mesa) {
        try {
            mesa.setEstado(true);
            mesa.setServicio(new Servicio());
            notificar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Cierra una mesa.
     *
     * @param mesa La mesa a cerrar.
     * @return true si la mesa se cerró con éxito, false en caso contrario.
     */
    public boolean cerrarMesa(Mesa mesa) {
        try {
            mesa.setEstado(false);

            if (mesa.getServicio().getItems().size() > 0) {
                Servicio serv = mesa.getServicio();
                List<ItemPedido> items = serv.getItems();

                mapeadorServicio.save(serv);

                for (ItemPedido item : items) {
                    mapeadorItemPedido.save(item);
                }
            }
            notificar();
            return true;
        } catch (Exception e) {
            System.out.println("Error al cerrar mesa: " + e.getMessage());
            return false;
        }
    }

    /**
     * Agrega un observador.
     *
     * @param o El observador a agregar.
     */
    public void agregarObserver(Observer o) {
        observadores.add(o);
    }

    /**
     * Notifica a todos los observadores.
     */
    public void notificar() {
        Facade.Instancia().notificar();
    }

    /**
     * Verifica si el mozo tiene mesas abiertas.
     *
     * @param mozo El mozo a verificar.
     * @return true si el mozo tiene mesas abiertas, false en caso contrario.
     */
    public boolean mesasAbiertasMozo(Usuario mozo) {
        return mesas.stream().anyMatch(m -> m.getMozo() == mozo && m.getEstado());
    }

    /**
     * Devuelve la lista de mesas asignadas a un mozo.
     *
     * @param mozo El mozo a verificar.
     * @return La lista de mesas asignadas al mozo.
     */
    public List<Mesa> mesasDeMozo(Usuario mozo) {
        List<Mesa> lista = new ArrayList<>();
        for (Mesa m : mesas) {
            if (m.getMozo() == mozo) {
                lista.add(m);
            }
        }
        return lista;
    }

    /**
     * Elimina una mesa.
     *
     * @param numero El número de la mesa a eliminar.
     * @return true si la mesa se eliminó con éxito, false en caso contrario.
     */
    public boolean eliminarMesa(int numero) {
        Mesa mesa = getMesa(numero);

        if (mesa != null) {
            try {
                mesas.remove(mesa);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    /**
     * Crea un nuevo producto.
     *
     * @param codigo El código del producto.
     * @param nombre El nombre del producto.
     * @param precio El precio del producto.
     * @param stock La cantidad en stock del producto.
     * @param tipoUp El tipo de unidad procesadora de pedidos.
     * @return true si el producto se creó con éxito, false en caso contrario.
     */
    public boolean crearProducto(String codigo, String nombre, double precio, int stock, TipoUnidadProcesadoraPedidos tipoUp) {
        if (productos.stream().anyMatch(p -> p.getCodigo().equals(codigo))) {
            return false;
        }

        try {
            Producto p = new Producto(codigo, nombre, precio, stock, tipoUp);
            productos.add(p);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Modifica un producto existente.
     *
     * @param codigo El código del producto.
     * @param nombre El nombre del producto.
     * @param precio El precio del producto.
     * @param stock La cantidad en stock del producto.
     * @param tipoUp El tipo de unidad procesadora de pedidos.
     * @return true si el producto se modificó con éxito, false en caso contrario.
     */
    public boolean modificarProducto(String codigo, String nombre, double precio, int stock, TipoUnidadProcesadoraPedidos tipoUp) {
        Producto p = getProducto(codigo);
        if (p != null) {
            try {
                p.setNombre(nombre);
                p.setPrecio(precio);
                p.setStock(stock);
                p.setUnidadProcesadoraPedidos(tipoUp);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    /**
     * Elimina un producto existente.
     *
     * @param codigo El código del producto.
     * @return true si el producto se eliminó con éxito, false en caso contrario.
     */
    public boolean eliminarProducto(String codigo) {
        Producto p = getProducto(codigo);
        if (p != null) {
            try {
                productos.remove(p);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    /**
     * Reduce el stock de un producto.
     *
     * @param producto El producto.
     * @param cantidad La cantidad a reducir.
     */
    public void reducirStock(Producto producto, int cantidad) {
        producto.setStock(producto.getStock() - cantidad);
        MapeadorProducto map = new MapeadorProducto(producto);
        persistencia.guardar(map);
    }

    /**
     * Aumenta el stock de un producto.
     *
     * @param producto El producto.
     * @param cantidad La cantidad a aumentar.
     */
    public void aumentarStock(Producto producto, int cantidad) {
        producto.setStock(producto.getStock() + cantidad);
    }

    /**
     * Notifica a todas las mesas.
     */
    public void notificarMesas() {
        for (Mesa m : mesas) {
            m.getServicio().notificar();
        }
    }

    /**
     * Busca un producto por su código.
     *
     * @param codigo El código del producto.
     * @return El producto encontrado o null si no se encuentra.
     */
    public Producto buscarProducto(String codigo) {
        return productos.stream().filter(p -> p.getCodigo().equals(codigo)).findFirst().orElse(null);
    }

    /**
     * Busca un producto por su OID.
     *
     * @param oid El OID del producto.
     * @return El producto encontrado o null si no se encuentra.
     */
    public Producto buscarProducto(int oid) {
        return productos.stream().filter(p -> p.getOid() == oid).findFirst().orElse(null);
    }

    /**
     * Carga una lista de productos.
     *
     * @param productos La lista de productos a cargar.
     */
    public void cargarProductos(List<Producto> productos) {
        this.productos.addAll(productos);
    }
}
