package com.test.testing.dominio.model;

import com.test.testing.testdatabuilder.CountryTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CountryTest {

    private CountryTestDataBuilder countryTestDataBuilder;

    @BeforeEach
    void setUp() {
        countryTestDataBuilder = new CountryTestDataBuilder();
    }

    @Test
    void calculateYearsOfIndependency() {
        Country country = countryTestDataBuilder.build();
        Assertions.assertEquals(26, country.getDayssOfIndependency());
        Assertions.assertEquals(6, country.getMonthsOfIndependency());
        Assertions.assertEquals(210, country.getYearsOfIndependency());
    }
}