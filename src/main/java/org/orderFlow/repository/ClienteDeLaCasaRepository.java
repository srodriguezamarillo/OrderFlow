package org.orderFlow.repository;

import org.orderFlow.model.ClienteDeLaCasa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad ClienteDeLaCasa.
 */
@Repository
public interface ClienteDeLaCasaRepository extends CrudRepository<ClienteDeLaCasa, Integer> {
}
