package com.test.testing.testdatabuilder;

import com.test.testing.dominio.model.Country;

public class CountryTestDataBuilder {

    private static final String COUNTRY_NAME="Colombia";
    private static final String CAPITAL_NAME="Bogota";
    private static final String INDEPENDENCE_DATE="20/07/1810";

    private String countryName;
    private String capitalName;
    private String independenceDate;

    public CountryTestDataBuilder() {
        this.countryName = COUNTRY_NAME;
        this.capitalName = CAPITAL_NAME;
        this.independenceDate = INDEPENDENCE_DATE;
    }

    public CountryTestDataBuilder(String countryName, String capitalName, String independenceDate) {
        this.countryName = countryName;
        this.capitalName = capitalName;
        this.independenceDate = independenceDate;
    }

    public Country build(){
        return new Country(countryName, capitalName, independenceDate);
    }
}
