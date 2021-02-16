package com.test.testing.infraestructura.controlador;

import com.test.testing.aplicacion.manejadores.ManejadorCrearCountry;
import com.test.testing.aplicacion.manejadores.ManejadorObtenerCountry;
import com.test.testing.dominio.model.Country;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/country")
public class ControladorCountry {

    Country country;
    ManejadorObtenerCountry manejadorObtenerCountry;
    ManejadorCrearCountry manejadorCrearCountry;

    public ControladorCountry(ManejadorCrearCountry manejadorCrearCountry, ManejadorObtenerCountry manejadorObtenerCountry) {
        this.manejadorCrearCountry = manejadorCrearCountry;
        this.manejadorObtenerCountry = manejadorObtenerCountry;
    }

    @GetMapping(path = "/{countryId}")
    public ResponseEntity<Country> getCountryDetails(@PathVariable("countryId") String countryId) {
        country = manejadorObtenerCountry.ejecutar(countryId);
        return ResponseEntity.ok(country);
    }

    @PostMapping(path = "/form")
    public void addCountry(@RequestBody Country country) {
        manejadorCrearCountry.ejecutar(country);
    }
}