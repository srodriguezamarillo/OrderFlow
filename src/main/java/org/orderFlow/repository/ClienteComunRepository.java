package org.orderFlow.repository;

import org.orderFlow.model.ClienteComun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar operaciones CRUD de ClienteComun.
 */
@Repository
public interface ClienteComunRepository extends JpaRepository<ClienteComun, Integer> {
}
