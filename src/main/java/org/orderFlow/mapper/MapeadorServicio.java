package org.orderFlow.mapper;

import org.orderFlow.model.Servicio;
import org.orderFlow.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Servicio para la gestión de Servicio.
 */
@Service
public class MapeadorServicio {

    @Autowired
    private ServicioRepository servicioRepository;

    /**
     * Guarda un nuevo Servicio en la base de datos.
     *
     * @param servicio El servicio a guardar.
     * @return El servicio guardado.
     */
    public Servicio save(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    /**
     * Actualiza un Servicio existente en la base de datos.
     *
     * @param servicio El servicio a actualizar.
     * @return El servicio actualizado.
     */
    public Servicio update(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    /**
     * Elimina un Servicio de la base de datos.
     *
     * @param oid El ID del servicio a eliminar.
     */
    public void delete(int oid) {
        servicioRepository.deleteById(oid);
    }

    /**
     * Encuentra un Servicio por su ID.
     *
     * @param oid El ID del servicio a encontrar.
     * @return El servicio encontrado, o vacío si no se encuentra.
     */
    public Optional<Servicio> findById(int oid) {
        return servicioRepository.findById(oid);
    }

    /**
     * Encuentra todos los Servicios.
     *
     * @return Una lista de todos los servicios.
     */
    public Iterable<Servicio> findAll() {
        return servicioRepository.findAll();
    }
}
