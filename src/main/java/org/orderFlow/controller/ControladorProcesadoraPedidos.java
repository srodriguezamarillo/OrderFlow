package org.orderFlow.controller;

import org.orderFlow.model.Facade;
import org.orderFlow.model.UPP;
import org.orderFlow.model.UPP.TipoUnidadProcesadoraPedidos;
import org.orderFlow.interfaces.IVistaProcesadoraPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.ArrayList;

/**
 * Controlador para la gestión de unidades procesadoras de pedidos.
 * Implementa la lógica para obtener y buscar unidades procesadoras de pedidos.
 */
@Controller
public class ControladorProcesadoraPedidos {

    private IVistaProcesadoraPedidos vista;

    /**
     * Constructor que inicializa el controlador con la vista correspondiente.
     *
     * @param vista La interfaz de la vista de unidades procesadoras de pedidos.
     */
    @Autowired
    public ControladorProcesadoraPedidos(IVistaProcesadoraPedidos vista) {
        this.vista = vista;
    }

    /**
     * Obtiene una lista de tipos de unidades procesadoras de pedidos.
     *
     * @return Lista de tipos de unidades procesadoras de pedidos.
     */
    public ArrayList<UPP.TipoUnidadProcesadoraPedidos> getListaUpps() {
        return (ArrayList<TipoUnidadProcesadoraPedidos>) Facade.Instancia().getEnumerado();
    }

    /**
     * Busca una unidad procesadora de pedidos por su tipo.
     *
     * @param tipo El tipo de unidad procesadora de pedidos.
     * @return La unidad procesadora de pedidos encontrada.
     */
    public UPP buscarUpp(TipoUnidadProcesadoraPedidos tipo) {
        return Facade.Instancia().buscarUpp(tipo);
    }
}
