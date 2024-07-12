package org.orderFlow.repository;

import org.orderFlow.model.Servicio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad Servicio.
 */
@Repository
public interface ServicioRepository extends CrudRepository<Servicio, Integer> {
}
