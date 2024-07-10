package org.orderFlow.mapper;

import org.orderFlow.model.ClienteComun;
import org.orderFlow.repository.ClienteComunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Servicio para la gestión de ClienteComun.
 * Proporciona métodos CRUD utilizando Spring Data JPA.
 */
@Service
public class MapeadorClienteComun {

    @Autowired
    private ClienteComunRepository clienteComunRepository;

    /**
     * Guarda un nuevo ClienteComun en la base de datos.
     *
     * @param cliente El cliente a guardar.
     * @return El cliente guardado.
     */
    public ClienteComun save(ClienteComun cliente) {
        return clienteComunRepository.save(cliente);
    }

    /**
     * Actualiza un ClienteComun existente en la base de datos.
     *
     * @param cliente El cliente a actualizar.
     * @return El cliente actualizado.
     */
    public ClienteComun update(ClienteComun cliente) {
        return clienteComunRepository.save(cliente);
    }

    /**
     * Elimina un ClienteComun de la base de datos.
     *
     * @param oid El ID del cliente a eliminar.
     */
    public void delete(int oid) {
        clienteComunRepository.deleteById(oid);
    }

    /**
     * Encuentra un ClienteComun por su ID.
     *
     * @param oid El ID del cliente a encontrar.
     * @return El cliente encontrado, o vacío si no se encuentra.
     */
    public Optional<ClienteComun> findById(int oid) {
        return clienteComunRepository.findById(oid);
    }

    /**
     * Encuentra todos los ClienteComun.
     *
     * @return Una lista de todos los clientes.
     */
    public Iterable<ClienteComun> findAll() {
        return clienteComunRepository.findAll();
    }
}
