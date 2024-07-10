package org.orderFlow.model;

import java.util.ArrayList;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Clase que representa a un cliente preferencial.
 * Extiende la clase Cliente y proporciona una implementación específica para clientes preferenciales.
 */
@Entity
@DiscriminatorValue("PREFERENCIAL")
public class ClientePreferencial extends Cliente {

    /**
     * Constructor que inicializa un nuevo cliente preferencial con nombre y email.
     *
     * @param nombre El nombre del cliente.
     * @param email El email del cliente.
     */
    public ClientePreferencial(String nombre, String email) {
        super(nombre, email);
    }

    /**
     * Constructor por defecto.
     */
    public ClientePreferencial() {}

    /**
     * Calcula el total de los pedidos para un cliente preferencial.
     * Excluye los pedidos de agua mineral y aplica un descuento del 5% si el total es mayor a 2000.
     *
     * @param pedidos La lista de pedidos.
     * @return El total calculado después de aplicar descuentos.
     */
    @Override
    public double calcularTotal(ArrayList<ItemPedido> pedidos) {
        double total = 0;

        for (ItemPedido ip : pedidos) {
            if (!ip.getProducto().getNombre().equals("Agua mineral")) {
                total += ip.getTotal();
            }
        }

        if (total > 2000) {
            total = total - (total * 0.05);
        }

        return total;
    }
}
