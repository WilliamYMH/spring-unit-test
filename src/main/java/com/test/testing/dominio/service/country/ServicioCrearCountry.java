package com.test.testing.dominio.service.country;
import com.test.testing.dominio.model.Country;
import com.test.testing.dominio.repositorio.RepositorioCountry;
import org.springframework.stereotype.Component;

@Component
public class ServicioCrearCountry {

    private final RepositorioCountry repositorioCountry;

    public ServicioCrearCountry(RepositorioCountry repositorioCountry) {
        this.repositorioCountry = repositorioCountry;
    }

    public void ejecutar(Country country) {
        this.repositorioCountry.guardarCountry(country);
    }
}
