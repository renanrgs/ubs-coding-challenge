package com.ubs.codingchallenge.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ubs.codingchallenge.web.dto.CountryDTO;
import com.ubs.codingchallenge.web.service.CountryService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.ubs.codingchallenge.util.TestUtil.oceaniaDeserializedCountryProvider;
import static com.ubs.codingchallenge.util.TestUtil.southAmericaDeserializedCountryProvider;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class CountryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CountryService countryService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void get10BiggestCountriesByRegion() throws Exception {
        //Given
        String region = "oceania";
        List<CountryDTO> countries = oceaniaDeserializedCountryProvider();

        //when
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/country/biggest/" + region).accept(APPLICATION_JSON));

        //Then
        result.andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(countries), true));
    }

    @Test
    void getCountriesBySubRegionContainingOver3Boardes() throws Exception {
        //Given
        String subregion = "southamerica";
        List<CountryDTO> countries = southAmericaDeserializedCountryProvider();

        //when
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/country/subregion/" + subregion).accept(APPLICATION_JSON));

        //Then
        result.andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(countries), true));
    }

    @Test
    void getSubregionPopulation() {

    }
}