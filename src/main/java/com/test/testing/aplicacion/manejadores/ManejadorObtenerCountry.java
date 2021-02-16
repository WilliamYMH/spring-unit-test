package com.test.testing.aplicacion.manejadores;

import com.test.testing.dominio.model.Country;
import com.test.testing.dominio.service.country.ServicioObtenerCountry;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManejadorObtenerCountry {

    private final ServicioObtenerCountry servicioObtenerCountry;

    public ManejadorObtenerCountry(ServicioObtenerCountry servicioObtenerCountry) {
        this.servicioObtenerCountry = servicioObtenerCountry;
    }

    @Transactional
    public Country ejecutar(String id) {
        System.out.println("ejecutar - ManejadorObtenerCountry");
        return this.servicioObtenerCountry.ejecutar(id);
    }
}
