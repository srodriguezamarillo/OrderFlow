package org.orderFlow.mapper;

import org.orderFlow.model.ClientePreferencial;
import org.orderFlow.repository.ClientePreferencialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Servicio para la gestión de ClientePreferencial.
 */
@Service
public class MapeadorClientePreferencial {

    @Autowired
    private ClientePreferencialRepository clientePreferencialRepository;

    /**
     * Guarda un nuevo ClientePreferencial en la base de datos.
     *
     * @param cliente El cliente a guardar.
     * @return El cliente guardado.
     */
    public ClientePreferencial save(ClientePreferencial cliente) {
        return clientePreferencialRepository.save(cliente);
    }

    /**
     * Actualiza un ClientePreferencial existente en la base de datos.
     *
     * @param cliente El cliente a actualizar.
     * @return El cliente actualizado.
     */
    public ClientePreferencial update(ClientePreferencial cliente) {
        return clientePreferencialRepository.save(cliente);
    }

    /**
     * Elimina un ClientePreferencial de la base de datos.
     *
     * @param oid El ID del cliente a eliminar.
     */
    public void delete(int oid) {
        clientePreferencialRepository.deleteById(oid);
    }

    /**
     * Encuentra un ClientePreferencial por su ID.
     *
     * @param oid El ID del cliente a encontrar.
     * @return El cliente encontrado, o vacío si no se encuentra.
     */
    public Optional<ClientePreferencial> findById(int oid) {
        return clientePreferencialRepository.findById(oid);
    }

    /**
     * Encuentra todos los ClientePreferencial.
     *
     * @return Una lista de todos los clientes.
     */
    public Iterable<ClientePreferencial> findAll() {
        return clientePreferencialRepository.findAll();
    }
}
