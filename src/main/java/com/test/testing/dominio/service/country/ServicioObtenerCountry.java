package com.test.testing.dominio.service.country;
import com.test.testing.dominio.model.Country;
import com.test.testing.dominio.repositorio.RepositorioCountry;
import com.test.testing.infraestructura.persistencia.builder.CountryBuilder;
import org.springframework.stereotype.Component;

@Component
public class ServicioObtenerCountry {

    private final RepositorioCountry repositorioCountry;

    public ServicioObtenerCountry(RepositorioCountry repositorioCountry) {
        this.repositorioCountry = repositorioCountry;
    }

    public Country ejecutar(String id) {
        return this.repositorioCountry.obtenerCountryPorId(Long.parseLong(id)).orElse(null);
    }
}
