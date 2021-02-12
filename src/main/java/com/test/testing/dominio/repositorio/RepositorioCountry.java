package com.test.testing.dominio.repositorio;
import com.test.testing.dominio.model.Country;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioCountry {

    void guardarCountry(Country country);
    Optional<Country> obtenerCountryPorId(Long id);
}