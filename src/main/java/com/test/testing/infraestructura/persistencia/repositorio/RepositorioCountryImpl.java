package com.test.testing.infraestructura.persistencia.repositorio;

import com.test.testing.dominio.model.Country;
import com.test.testing.dominio.repositorio.RepositorioCountry;
import com.test.testing.infraestructura.persistencia.builder.CountryBuilder;
import com.test.testing.infraestructura.persistencia.dao.CountryDao;
import com.test.testing.infraestructura.persistencia.entidad.CountryEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RepositorioCountryImpl implements RepositorioCountry {

    private final CountryDao countryDao;

    public RepositorioCountryImpl(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @Override
    public void guardarCountry(Country country) {
        CountryEntity countryEntity = CountryBuilder.convertirAEntity(country);
        countryDao.save(countryEntity);
    }

    @Override
    public Optional<Country> obtenerCountryPorId(Long id) {
        return countryDao.findById(id).map(CountryBuilder::convertirADominio);
    }
}
