package com.test.testing.aplicacion.manejadores;

import com.test.testing.dominio.model.Country;
import com.test.testing.dominio.service.country.ServicioCrearCountry;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManejadorCrearCountry {

    private final ServicioCrearCountry servicioCrearCountry;

    public ManejadorCrearCountry(ServicioCrearCountry servicioCrearCountry) {
        this.servicioCrearCountry = servicioCrearCountry;
    }

    @Transactional
    public void ejecutar(Country country) {
        this.servicioCrearCountry.ejecutar(country);
    }
}
