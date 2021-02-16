package com.test.testing.infraestructura.controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.testing.dominio.model.Country;
import com.test.testing.testdatabuilder.CountryTestDataBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class ControladorCountryTestIT {

    Country country;
    CountryTestDataBuilder countryTestDataBuilder;
    ObjectMapper objectMapper;

    @Autowired
    private MockMvc mvc;

    @BeforeEach
    void setUp(){
        countryTestDataBuilder = new CountryTestDataBuilder("República Dominicana", "Santo Domingo", "23/11/1986");
        country = countryTestDataBuilder.build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void getCountryDetails() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/country/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.countryName").value(country.getCountryName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.capitalName").value(country.getCapitalName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.independenceDate").value(country.getIndependenceDate()));
    }

    @Test
    void addCountry() throws Exception {
        countryTestDataBuilder = new CountryTestDataBuilder();
        country = countryTestDataBuilder.build();
        mvc.perform(MockMvcRequestBuilders.post("/country/form")
                .content(objectMapper.writeValueAsString(country))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(MockMvcRequestBuilders.get("/country/{id}", 11))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.countryName").value(country.getCountryName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.capitalName").value(country.getCapitalName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.independenceDate").value(country.getIndependenceDate()));
    }


    @AfterEach
    void tearDown(){

    }
}