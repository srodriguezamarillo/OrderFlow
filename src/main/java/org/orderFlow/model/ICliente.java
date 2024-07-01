package org.orderFlow.model;

import java.util.ArrayList;

/**
 * Interfaz que define los métodos que deben ser implementados por las clases de clientes.
 */
public interface ICliente {

    /**
     * Devuelve el OID del cliente.
     *
     * @return El OID del cliente.
     */
    int getOid();

    /**
     * Establece el OID del cliente.
     *
     * @param oid El OID a establecer.
     */
    void setOid(int oid);

    /**
     * Calcula el total de los pedidos.
     *
     * @param pedidos La lista de pedidos.
     * @return El total calculado.
     */
    double calcularTotal(ArrayList<ItemPedido> pedidos);
}
