package org.orderFlow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Table;
import java.util.ArrayList;

/**
 * Clase que representa a un cliente de la casa.
 * Extiende la clase Cliente y proporciona una implementación específica para clientes de la casa.
 */
@Entity
@Table(name = "clientes_de_la_casa")
@DiscriminatorValue("DE_LA_CASA")
public class ClienteDeLaCasa extends Cliente {

    /**
     * Constructor que inicializa un nuevo cliente de la casa con nombre y email.
     *
     * @param nombre El nombre del cliente.
     * @param email El email del cliente.
     */
    public ClienteDeLaCasa(String nombre, String email) {
        super(nombre, email);
    }

    /**
     * Constructor por defecto.
     */
    public ClienteDeLaCasa() {}

    /**
     * Calcula el total de los pedidos para un cliente de la casa.
     * Aplica un descuento de 500 al total.
     *
     * @param pedidos La lista de pedidos.
     * @return El total calculado después del descuento.
     */
    @Override
    public double calcularTotal(ArrayList<ItemPedido> pedidos) {
        double total = 0;

        for (ItemPedido ip : pedidos) {
            total += ip.getTotal();
        }

        total -= 500;

        if (total < 0) {
            total = 0;
        }

        return total;
    }
}
