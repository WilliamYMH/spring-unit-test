package com.test.testing.infraestructura.persistencia.builder;

import com.test.testing.dominio.model.Country;
import com.test.testing.infraestructura.persistencia.entidad.CountryEntity;

public final class CountryBuilder {

    private CountryBuilder() {
    }

    public static Country convertirADominio(CountryEntity countryEntity) {
        Country country = null;
        if (countryEntity != null) {
            country = new Country(countryEntity.getCountryName(), countryEntity.getCountryCapital(), countryEntity.getCountryIdependenceDate());
        }
        return country;
    }

    public static CountryEntity convertirAEntity(Country country) {
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setCountryName(country.getCountryName());
        countryEntity.setCountryCapital(country.getCapitalName());
        countryEntity.setCountryIdependenceDate(country.getIndependenceDate());
        return countryEntity;
    }
}
