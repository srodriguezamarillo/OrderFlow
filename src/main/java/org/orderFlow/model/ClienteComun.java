package org.orderFlow.model;

import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Table;
import java.util.ArrayList;

/**
 * Clase que representa a un cliente común.
 * Extiende la clase Cliente y proporciona una implementación específica para clientes comunes.
 */
@Entity
@Table(name = "clientes_comunes")
@DiscriminatorValue("COMUN")
public class ClienteComun extends Cliente {

    /**
     * Constructor que inicializa un nuevo cliente común con nombre y email.
     *
     * @param nombre El nombre del cliente.
     * @param email El email del cliente.
     */
    public ClienteComun(String nombre, String email) {
        super(nombre, email);
    }

    /**
     * Constructor por defecto.
     */
    public ClienteComun() {}

    /**
     * Calcula el total de los pedidos para un cliente común.
     * Excluye los pedidos de café del total.
     *
     * @param pedidos La lista de pedidos.
     * @return El total calculado.
     */
    @Override
    public double calcularTotal(ArrayList<ItemPedido> pedidos) {
        double total = 0;

        for (ItemPedido ip : pedidos) {
            if (!ip.getProducto().getNombre().equals("Cafe")) {
                total += ip.getTotal();
            }
        }

        return total;
    }
}
