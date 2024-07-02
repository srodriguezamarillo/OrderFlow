package org.orderFlow.mapper;

import org.orderFlow.model.ClienteComun;
import org.orderFlow.repository.ClienteComunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para la gestión de clientes comunes.
 * Proporciona métodos para interactuar con la base de datos.
 */
@Service
public class MapeadorClienteComun {

    @Autowired
    private ClienteComunRepository clienteComunRepository;

    private ClienteComun cliente;

    /**
     * Constructor que inicializa el mapeador con un cliente.
     *
     * @param cliente El cliente a mapear.
     */
    public MapeadorClienteComun(ClienteComun cliente) {
        this.cliente = cliente;
    }

    /**
     * Guarda un cliente común en la base de datos.
     *
     * @return El cliente guardado.
     */
    public ClienteComun saveClienteComun() {
        return clienteComunRepository.save(cliente);
    }

    /**
     * Encuentra un cliente común por su ID.
     *
     * @param id El ID del cliente.
     * @return El cliente, si se encuentra.
     */
    public Optional<ClienteComun> findClienteComunById(int id) {
        return clienteComunRepository.findById(id);
    }

    /**
     * Borra un cliente común por su ID.
     *
     * @param id El ID del cliente.
     */
    public void deleteClienteComunById(int id) {
        clienteComunRepository.deleteById(id);
    }

    /**
     * Devuelve todos los clientes comunes.
     *
     * @return Lista de clientes comunes.
     */
    public List<ClienteComun> findAllClientesComunes() {
        return clienteComunRepository.findAll();
    }

    /**
     * Obtiene el OID del cliente.
     *
     * @return El OID del cliente.
     */
    public int getOid() {
        return cliente.getOid();
    }

    /**
     * Establece el OID del cliente.
     *
     * @param oid El OID a establecer.
     */
    public void setOid(int oid) {
        cliente.setOid(oid);
    }

    /**
     * Obtiene el cliente asociado a este mapeador.
     *
     * @return El cliente asociado.
     */
    public ClienteComun getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente para este mapeador.
     *
     * @param cliente El cliente a establecer.
     */
    public void setCliente(ClienteComun cliente) {
        this.cliente = cliente;
    }
}
