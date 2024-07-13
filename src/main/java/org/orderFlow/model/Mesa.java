package org.orderFlow.model;

import jakarta.persistence.*;

/**
 * Clase que representa una mesa en el restaurante.
 */
@Entity
@Table(name = "mesas")
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private int numero;

    @ManyToOne
    @JoinColumn(name = "mozo_id")
    private Usuario mozo;

    @Column(nullable = false)
    private boolean estado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "servicio_id", referencedColumnName = "id")
    private Servicio servicio;

    /**
     * Constructor que inicializa una nueva mesa con un número.
     *
     * @param numero El número de la mesa.
     */
    public Mesa(int numero) {
        setNumero(numero);
        setEstado(false);
        setMozo(null);
        setServicio(new Servicio());
        Facade.Instancia().getSmesas().getMesas().add(this);
    }

    /**
     * Constructor por defecto.
     */
    public Mesa() {}

    /**
     * Devuelve el número de la mesa.
     *
     * @return El número de la mesa.
     */
    public int getNumero() {
        return this.numero;
    }

    /**
     * Establece el número de la mesa.
     *
     * @param numero El número de la mesa.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Devuelve el mozo asignado a la mesa.
     *
     * @return El mozo asignado a la mesa.
     */
    public Usuario getMozo() {
        return this.mozo;
    }

    /**
     * Establece el mozo asignado a la mesa.
     *
     * @param mozo El mozo a asignar.
     */
    public void setMozo(Usuario mozo) {
        this.mozo = mozo;
    }

    /**
     * Devuelve el estado de la mesa (abierta o cerrada).
     *
     * @return true si la mesa está abierta, false si está cerrada.
     */
    public boolean getEstado() {
        return this.estado;
    }

    /**
     * Establece el estado de la mesa (abierta o cerrada).
     *
     * @param estado El estado de la mesa.
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Devuelve el servicio asociado a la mesa.
     *
     * @return El servicio asociado a la mesa.
     */
    public Servicio getServicio() {
        return this.servicio;
    }

    /**
     * Establece un nuevo servicio para la mesa.
     *
     * @param servicio El nuevo servicio a establecer.
     */
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    /**
     * Verifica si la mesa tiene ítems pendientes.
     *
     * @return true si la mesa tiene ítems pendientes, false en caso contrario.
     */
    public boolean itemsPendientes() {
        return servicio.itemsPendientes();
    }

    @Override
    public String toString() {
        return this.getNumero() + " " + "\n" + (this.getMozo() != null ? this.getMozo().getNombre() : "Sin mozo asignado");
    }
}
