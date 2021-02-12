package com.test.testing.infraestructura.controlador;

import com.test.testing.dominio.model.Country;
import com.test.testing.infraestructura.persistencia.entidad.CountryEntity;
import com.test.testing.infraestructura.persistencia.repositorio.RepositorioCountryImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Period;
import java.util.Optional;

/**
 * Author: VIP
 */
@RestController()
public class ControladorCountry {

    Country country;
    Optional<Country> countryOptional;
    RepositorioCountryImpl countryRepositoryImpl;
    //DiferenciaEntreFechas diferenciaEntreFechas;

    public ControladorCountry(RepositorioCountryImpl countryRepositoryImpl) {
        this.countryRepositoryImpl = countryRepositoryImpl;
        //this.diferenciaEntreFechas = diferenciaEntreFechas;
    }

    @GetMapping(path = "/country/{countryId}")
    public ResponseEntity<Country> getCountryDetails(@PathVariable("countryId") String countryId) {
        countryOptional = Optional.of(new Country());
        country = null;

        countryOptional = countryRepositoryImpl.obtenerCountryPorId(Long.parseLong(countryId));
        if (countryOptional.isPresent()) {
            country = new Country(countryOptional.get().getCountryName(), countryOptional.get().getCapitalName(), countryOptional.get().getIndependenceDate());
        }
        return ResponseEntity.ok(country);
    }
}