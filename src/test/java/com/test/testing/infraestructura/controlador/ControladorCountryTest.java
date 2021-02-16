package com.test.testing.infraestructura.controlador;

import com.test.testing.aplicacion.manejadores.ManejadorCrearCountry;
import com.test.testing.aplicacion.manejadores.ManejadorObtenerCountry;
import com.test.testing.dominio.model.Country;
import com.test.testing.dominio.service.country.ServicioCrearCountry;
import com.test.testing.dominio.service.country.ServicioObtenerCountry;
import com.test.testing.infraestructura.persistencia.repositorio.RepositorioCountryImpl;
import com.test.testing.testdatabuilder.CountryTestDataBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

class ControladorCountryTest {

    Country country;
    RepositorioCountryImpl countryRepositoryImplMock;
    ControladorCountry controladorCountry;
    CountryTestDataBuilder countryTestDataBuilder;
    ManejadorCrearCountry manejadorCrearCountry;
    ManejadorObtenerCountry manejadorObtenerCountry;
    ServicioCrearCountry servicioCrearCountry;
    ServicioObtenerCountry servicioObtenerCountry;

    @BeforeEach
    void setUp(){
        countryTestDataBuilder = new CountryTestDataBuilder();
        countryRepositoryImplMock = Mockito.mock(RepositorioCountryImpl.class);

        servicioCrearCountry = new ServicioCrearCountry(countryRepositoryImplMock);
        servicioObtenerCountry = new ServicioObtenerCountry(countryRepositoryImplMock);

        manejadorCrearCountry = new ManejadorCrearCountry(servicioCrearCountry);
        manejadorObtenerCountry = new ManejadorObtenerCountry(servicioObtenerCountry);

        controladorCountry = new ControladorCountry(manejadorCrearCountry, manejadorObtenerCountry);

        country = countryTestDataBuilder.build();
        Optional<Country> countryOptional = Optional.of(country);
        Mockito.when(countryRepositoryImplMock.obtenerCountryPorId(1L)).thenReturn(countryOptional);
    }

    @Test
    void getCountryDetailsWithValidId() {
        ResponseEntity<Country> responseEntity;
        responseEntity = controladorCountry.getCountryDetails("1");
        Assertions.assertEquals(country.getCountryName(), responseEntity.getBody().getCountryName());
        Assertions.assertEquals(country.getCapitalName(), responseEntity.getBody().getCapitalName());
        Assertions.assertEquals(country.getIndependenceDate(), responseEntity.getBody().getIndependenceDate());
        Assertions.assertEquals(country.getDayssOfIndependency(), responseEntity.getBody().getDayssOfIndependency());
        Assertions.assertEquals(country.getMonthsOfIndependency(), responseEntity.getBody().getMonthsOfIndependency());
        Assertions.assertEquals(country.getYearsOfIndependency(), responseEntity.getBody().getYearsOfIndependency());
    }

    @Test
    void getCountryDetailsWithInValidId() {
        ResponseEntity<Country> responseEntity;
        responseEntity = controladorCountry.getCountryDetails("123");
        Assertions.assertNull(responseEntity.getBody());
    }

    @AfterEach
    void tearDown(){

    }
}