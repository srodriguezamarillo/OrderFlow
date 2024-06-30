package org.orderFlow.config;

import org.orderFlow.model.Usuario;
import org.orderFlow.model.Mesa;
import org.orderFlow.service.UsuarioService;
import org.orderFlow.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataLoader {

    private final UsuarioService usuarioService;
    private final MesaService mesaService;

    @Autowired
    public DataLoader(UsuarioService usuarioService, MesaService mesaService) {
        this.usuarioService = usuarioService;
        this.mesaService = mesaService;
    }

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            cargarDatos();
        };
    }

    private void cargarDatos() {
        Usuario mozo1 = new Usuario("Carlos Suarez", "csuarez", "1234", Usuario.TipoUser.MOZO);
        Usuario mozo2 = new Usuario("Martin Gonzalez", "mgonzalez", "1234", Usuario.TipoUser.MOZO);
        Usuario mozo3 = new Usuario("Mozo", "mozo", "mozo", Usuario.TipoUser.MOZO);
        Usuario mozo4 = new Usuario("Ana", "m1", "m1", Usuario.TipoUser.MOZO);
        Usuario mozo5 = new Usuario("Maria", "m2", "m2", Usuario.TipoUser.MOZO);
        Usuario mozo6 = new Usuario("Flor", "m3", "m3", Usuario.TipoUser.MOZO);
        Usuario gestor1 = new Usuario("Ana Perez", "aperez", "1234", Usuario.TipoUser.GESTOR);
        Usuario gestor2 = new Usuario("Silvia Morales", "smorales", "1234", Usuario.TipoUser.GESTOR);
        Usuario gestor3 = new Usuario("Gestor", "gestor", "gestor", Usuario.TipoUser.GESTOR);
        Usuario gestor4 = new Usuario("Pedro", "g1", "g1", Usuario.TipoUser.GESTOR);
        Usuario gestor5 = new Usuario("Juan", "g2", "g2", Usuario.TipoUser.GESTOR);
        Usuario gestor6 = new Usuario("Antonio", "g3", "g3", Usuario.TipoUser.GESTOR);

        usuarioService.saveAll(List.of(mozo1, mozo2, mozo3, mozo4, mozo5, mozo6, gestor1, gestor2, gestor3, gestor4, gestor5, gestor6));

        Mesa m1 = new Mesa(1);
        Mesa m2 = new Mesa(2);
        Mesa m3 = new Mesa(3);
        Mesa m4 = new Mesa(4);
        Mesa m5 = new Mesa(5);
        Mesa m6 = new Mesa(6);
        Mesa m7 = new Mesa(7);
        Mesa m8 = new Mesa(8);
        Mesa m9 = new Mesa(9);
        Mesa m10 = new Mesa(10);
        Mesa m11 = new Mesa(11);
        Mesa m12 = new Mesa(12);
        Mesa m13 = new Mesa(13);
        Mesa m14 = new Mesa(14);
        Mesa m15 = new Mesa(15);

        m1.setMozo(mozo4);
        m2.setMozo(mozo4);
        m3.setMozo(mozo4);
        m4.setMozo(mozo4);
        m5.setMozo(mozo4);
        m6.setMozo(mozo5);
        m7.setMozo(mozo5);
        m8.setMozo(mozo5);
        m9.setMozo(mozo5);
        m10.setMozo(mozo5);
        m11.setMozo(mozo6);
        m12.setMozo(mozo6);
        m13.setMozo(mozo6);
        m14.setMozo(mozo6);
        m15.setMozo(mozo6);

        mesaService.saveAll(List.of(m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, m15));
    }
}
