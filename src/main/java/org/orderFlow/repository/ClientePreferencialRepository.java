package org.orderFlow.repository;

import org.orderFlow.model.ClientePreferencial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad ClientePreferencial.
 */
@Repository
public interface ClientePreferencialRepository extends CrudRepository<ClientePreferencial, Integer> {
}
