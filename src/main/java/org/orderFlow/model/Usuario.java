package org.orderFlow.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Clase que representa a un usuario en el sistema.
 */
@Entity
@Table(name = "usuarios")
public class Usuario {

    public enum TipoUser {MOZO, GESTOR}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String user;

    @Column(nullable = false)
    private String pass;

    @Column(nullable = false)
    private TipoUser tipo;

    // Default constructor
    public Usuario() {}

    /**
     * Constructor que inicializa un usuario con los datos proporcionados.
     *
     * @param nombre El nombre del usuario.
     * @param user El nombre de usuario.
     * @param pass La contraseña del usuario.
     * @param tipo El tipo de usuario (Mozo o Gestor).
     */
    public Usuario(String nombre, String user, String pass, TipoUser tipo) {
        this.nombre = nombre;
        this.user = user;
        this.pass = pass;
        this.tipo = tipo;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public TipoUser getTipo() {
        return tipo;
    }

    public void setTipo(TipoUser tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
