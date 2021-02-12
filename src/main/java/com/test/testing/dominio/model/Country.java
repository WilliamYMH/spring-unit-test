package com.test.testing.dominio.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Country {
    private String countryName;
    private String capitalName;
    private String independenceDate;
    private int yearsOfIndependency;
    private int monthsOfIndependency;
    private int dayssOfIndependency;

    public Country() {

    }

    public Country(String countryName, String capitalName, String independenceDate) {
        this.countryName = countryName;
        this.capitalName = capitalName;
        this.independenceDate = independenceDate;

        Period period = this.calculateYearsOfIndependency();
        this.setDayssOfIndependency(period.getDays());
        this.setMonthsOfIndependency(period.getMonths());
        this.setYearsOfIndependency(period.getYears());
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    public String getIndependenceDate() {
        return independenceDate;
    }

    public void setIndependenceDate(String independenceDate) {
        this.independenceDate = independenceDate;
    }

    public void setYearsOfIndependency(int yearsOfIndependency) {
        this.yearsOfIndependency = yearsOfIndependency;
    }

    public void setMonthsOfIndependency(int monthsOfIndependency) {
        this.monthsOfIndependency = monthsOfIndependency;
    }

    public void setDayssOfIndependency(int dayssOfIndependency) {
        this.dayssOfIndependency = dayssOfIndependency;
    }

    public int getYearsOfIndependency() {
        return yearsOfIndependency;
    }

    public int getMonthsOfIndependency() {
        return monthsOfIndependency;
    }

    public int getDayssOfIndependency() {
        return dayssOfIndependency;
    }

    public Period calculateYearsOfIndependency() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

        LocalDate localDate = LocalDate.parse(this.independenceDate, formatter);
        LocalDate today = LocalDate.now();
        return Period.between(localDate, today);
    }
}
