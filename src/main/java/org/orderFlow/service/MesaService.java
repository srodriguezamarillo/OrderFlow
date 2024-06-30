package org.orderFlow.service;

import org.orderFlow.model.Mesa;
import org.orderFlow.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    public void saveAll(List<Mesa> mesas) {
        mesaRepository.saveAll(mesas);
    }

    public List<Mesa> findAll() {
        return mesaRepository.findAll();
    }
}
