package org.orderFlow.mapper;

import org.orderFlow.model.ItemPedido;
import org.orderFlow.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Servicio para la gestión de ItemPedido.
 */
@Service
public class MapeadorItemPedido {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    /**
     * Guarda un nuevo ItemPedido en la base de datos.
     *
     * @param itemPedido El ítem de pedido a guardar.
     * @return El ítem de pedido guardado.
     */
    public ItemPedido save(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    /**
     * Actualiza un ItemPedido existente en la base de datos.
     *
     * @param itemPedido El ítem de pedido a actualizar.
     * @return El ítem de pedido actualizado.
     */
    public ItemPedido update(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    /**
     * Elimina un ItemPedido de la base de datos.
     *
     * @param oid El ID del ítem de pedido a eliminar.
     */
    public void delete(int oid) {
        itemPedidoRepository.deleteById(oid);
    }

    /**
     * Encuentra un ItemPedido por su ID.
     *
     * @param oid El ID del ítem de pedido a encontrar.
     * @return El ítem de pedido encontrado, o vacío si no se encuentra.
     */
    public Optional<ItemPedido> findById(int oid) {
        return itemPedidoRepository.findById(oid);
    }

    /**
     * Encuentra todos los ItemPedido.
     *
     * @return Una lista de todos los ítems de pedido.
     */
    public Iterable<ItemPedido> findAll() {
        return itemPedidoRepository.findAll();
    }
}
