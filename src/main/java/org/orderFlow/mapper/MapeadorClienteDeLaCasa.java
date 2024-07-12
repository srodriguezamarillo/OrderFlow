package org.orderFlow.mapper;

import org.orderFlow.model.ClienteDeLaCasa;
import org.orderFlow.repository.ClienteDeLaCasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Servicio para la gestión de ClienteDeLaCasa.
<<<<<<< HEAD
=======
 * Proporciona métodos CRUD utilizando Spring Data JPA.
>>>>>>> a7a89cc (Reincorporando cambios desde el backup)
 */
@Service
public class MapeadorClienteDeLaCasa {

    @Autowired
    private ClienteDeLaCasaRepository clienteDeLaCasaRepository;

    /**
     * Guarda un nuevo ClienteDeLaCasa en la base de datos.
     *
     * @param cliente El cliente a guardar.
     * @return El cliente guardado.
     */
    public ClienteDeLaCasa save(ClienteDeLaCasa cliente) {
        return clienteDeLaCasaRepository.save(cliente);
    }

    /**
     * Actualiza un ClienteDeLaCasa existente en la base de datos.
     *
     * @param cliente El cliente a actualizar.
     * @return El cliente actualizado.
     */
    public ClienteDeLaCasa update(ClienteDeLaCasa cliente) {
        return clienteDeLaCasaRepository.save(cliente);
    }

    /**
     * Elimina un ClienteDeLaCasa de la base de datos.
     *
     * @param oid El ID del cliente a eliminar.
     */
    public void delete(int oid) {
        clienteDeLaCasaRepository.deleteById(oid);
    }

    /**
     * Encuentra un ClienteDeLaCasa por su ID.
     *
     * @param oid El ID del cliente a encontrar.
     * @return El cliente encontrado, o vacío si no se encuentra.
     */
    public Optional<ClienteDeLaCasa> findById(int oid) {
        return clienteDeLaCasaRepository.findById(oid);
    }

    /**
     * Encuentra todos los ClienteDeLaCasa.
     *
     * @return Una lista de todos los clientes.
     */
    public Iterable<ClienteDeLaCasa> findAll() {
        return clienteDeLaCasaRepository.findAll();
    }
}
