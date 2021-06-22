package com.ubs.codingchallenge.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ubs.codingchallenge.web.dto.CountryDTO;
import com.ubs.codingchallenge.web.dto.SubregionDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static com.ubs.codingchallenge.util.TestUtil.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class CountryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void givenRegionThenReturnCountryListJSON() throws Exception {
        //Given
        String region = "oceania";
        List<CountryDTO> countries = oceaniaCountryJSONProvider();

        //when
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/country/biggest/" + region).accept(APPLICATION_JSON));

        //Then
        result.andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(countries), true));
    }

    @Test
    void givenRegionThenReturnCountryListCSV() throws Exception {
        //Given
        String region = "oceania";
        List<CountryDTO> countries = oceaniaCountryJSONProvider();

        //when
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/country/biggest/" + region).accept(TEXT_CSV));

        //Then
        result.andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(TEXT_CSV));
    }

    @Test
    void givenSubregionThenReturnCountryListHavingOver3BordersJSON() throws Exception {
        //Given
        String subregion = "southamerica";
        List<CountryDTO> countries = southAmericaCountryJSONProvider();

        //when
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/country/subregion/" + subregion).accept(APPLICATION_JSON));

        //Then
        result.andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(countries), true));
    }

    @Test
    void givenSubregionThenReturnCountryListHavingOver3BordersCSV() throws Exception {
        //Given
        String subregion = "southamerica";
        List<CountryDTO> countries = southAmericaCountryJSONProvider();

        //when
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/country/subregion/" + subregion).accept(TEXT_CSV));

        //Then
        result.andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(TEXT_CSV));
    }

    @Test
    void givenSubregionThenReturnCountryListAndPopulationJSON() throws Exception {

        //Given
        String subregion = "southamerica";
        List<SubregionDTO> subregionWrapper = allSouthAmericaJSONProvider();

        //When
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/country/subregion/" + subregion + "/population").accept(APPLICATION_JSON));

        //Then
        result.andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(subregionWrapper), false));
    }

    @Test
    void givenSubregionThenReturnCountryListAndPopulationCSV() throws Exception {

        //Given
        String subregion = "southamerica";
        List<SubregionDTO> subregionWrapper = allSouthAmericaJSONProvider();

        //When
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/country/subregion/" + subregion + "/population").accept(TEXT_CSV));

        //Then
        result.andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(TEXT_CSV));
    }
}