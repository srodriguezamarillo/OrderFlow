package org.orderFlow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Table;
import java.util.ArrayList;

/**
 * Clase abstracta que representa a un cliente.
 * Implementa la interfaz ICliente y define las propiedades y métodos comunes a todos los tipos de clientes.
 */
@Entity
@Table(name = "clientes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
public abstract class Cliente implements ICliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oid;

    @Column(nullable = false)
    private int id;
    private static int idAutomatico = 10;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String email;

    /**
     * Constructor que inicializa un nuevo cliente con nombre y email.
     * El ID del cliente se asigna automáticamente.
     *
     * @param nombre El nombre del cliente.
     * @param email El email del cliente.
     */
    public Cliente(String nombre, String email) {
        this.id = idAutomatico++;
        this.nombre = nombre;
        this.email = email;
        Facade.Instancia().getSusuarios().getClientes().add(this);
    }

    /**
     * Constructor por defecto.
     */
    public Cliente() {}

    /**
     * Devuelve el OID del cliente.
     *
     * @return El OID del cliente.
     */
    @Override
    public int getOid() {
        return oid;
    }

    /**
     * Establece el OID del cliente.
     *
     * @param oid El OID a establecer.
     */
    @Override
    public void setOid(int oid) {
        this.oid = oid;
    }

    /**
     * Devuelve el ID del cliente.
     *
     * @return El ID del cliente.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del cliente.
     *
     * @param id El ID a establecer.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del cliente.
     *
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombre El nombre a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el email del cliente.
     *
     * @return El email del cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el email del cliente.
     *
     * @param email El email a establecer.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devuelve una representación en cadena del cliente.
     *
     * @return Una cadena con el ID y nombre del cliente.
     */
    @Override
    public String toString() {
        return this.id + " - " + this.nombre;
    }

    /**
     * Calcula el total de los pedidos.
     *
     * @param pedidos La lista de pedidos.
     * @return El total calculado.
     */
    @Override
    public double calcularTotal(ArrayList<ItemPedido> pedidos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
