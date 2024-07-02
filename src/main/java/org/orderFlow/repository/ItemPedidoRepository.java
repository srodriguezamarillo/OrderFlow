package org.orderFlow.repository;

import org.orderFlow.model.ItemPedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad ItemPedido.
 */
@Repository
public interface ItemPedidoRepository extends CrudRepository<ItemPedido, Integer> {
}
