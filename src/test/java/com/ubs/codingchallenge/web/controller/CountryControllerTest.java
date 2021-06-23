package com.ubs.codingchallenge.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ubs.codingchallenge.web.dto.CountryDTO;
import com.ubs.codingchallenge.web.dto.SubregionDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static com.ubs.codingchallenge.util.Bootstrap.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureRestDocs(uriScheme = "https", uriHost = "yourdomainhere.eu", uriPort = 80)
@AutoConfigureMockMvc
@ExtendWith(RestDocumentationExtension.class)
@SpringBootTest
class CountryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
    }

    @Test
    void givenRegionThenReturnCountryListJSON() throws Exception {
        //Given
        String region = "oceania";
        List<CountryDTO> countries = oceaniaCountryJSONProvider();

        //when
        ResultActions result = mockMvc.perform(get("/api/v1/country/region/{region}/biggest", region)
                .accept(APPLICATION_JSON));

        //Then
        result.andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(countries), true));
        assertDocumented(result, "region", "v1/country/region",
                "Region of desired list of countries to get.");
    }



    @Test
    void givenRegionThenReturnCountryListCSV() throws Exception {
        //Given
        String region = "oceania";
        List<CountryDTO> countries = oceaniaCountryJSONProvider();

        //when
        ResultActions result =
                mockMvc.perform(get("/api/v1/country/region/{region}/biggest", region)
                        .accept(TEXT_CSV));

        //Then
        result.andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(TEXT_CSV)).andDo(document("v1/country/regioncsv",
                pathParameters(
                        parameterWithName("region").description("Region of desired list of countries to get."))));
    }

    @Test
    void givenSubregionThenReturnCountryListHavingOver3BordersJSON() throws Exception {
        //Given
        String subregion = "southamerica";
        List<CountryDTO> countries = southAmericaCountryJSONProvider();

        //when
        ResultActions result =
                mockMvc.perform(get("/api/v1/country/subregion/{subregion}/borders", subregion)
                .accept(APPLICATION_JSON));

        //Then
        result.andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(countries), true));
        assertDocumented(result, "subregion", "v1/country/subregion/borders",
                "Subregion of desired list of countries");
    }

    @Test
    void givenSubregionThenReturnCountryListHavingOver3BordersCSV() throws Exception {
        //Given
        String subregion = "southamerica";

        //when
        ResultActions result =
                mockMvc.perform(get("/api/v1/country/subregion/{subregion}/borders", subregion)
                .accept(TEXT_CSV));

        //Then
        result.andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(TEXT_CSV)).andDo(document("v1/country/subregion/borderscsv",
                pathParameters(
                        parameterWithName("subregion").description("Subregion of desired list of countries."))));
    }

    @Test
    void givenSubregionThenReturnCountryListAndPopulationJSON() throws Exception {

        //Given
        String subregion = "southamerica";
        List<SubregionDTO> subregionWrapper = allSouthAmericaJSONProvider();

        //When
        ResultActions result =
                mockMvc.perform(get("/api/v1/country/subregion/{subregion}/population", subregion)
                .accept(APPLICATION_JSON));

        //Then
        result.andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
                    .andExpect(content().json(objectMapper.writeValueAsString(subregionWrapper), false)).andDo(document("v1/country/subregion/population",
                pathParameters(
                        parameterWithName("subregion").description("Subregion of desired list of countries")),
                responseFields(
                        fieldWithPath("[].totalPopulation").description("Subregion population."),
                        fieldWithPath("[].countries[].name").description("Name of the Country."),
                        fieldWithPath("[].countries[].capital").description("Capital of the Country."),
                        fieldWithPath("[].countries[].region").description("Region of the Country (Europe, Oceania, Americas, etc)."),
                        fieldWithPath("[].countries[].subregion").description("Subregion of the Country (South America, Easter Europe, Western Europe, etc)."),
                        fieldWithPath("[].countries[].population").description("Population of the Country."),
                        fieldWithPath("[].countries[].area").optional().description("Area of the Country."),
                        fieldWithPath("[].countries[].borders").description("Borders of the Country."),
                        fieldWithPath("[].countries[].borders[].name").ignored(),
                        fieldWithPath("[].countries[].borders[].capital").ignored(),
                        fieldWithPath("[].countries[].borders[].region").ignored(),
                        fieldWithPath("[].countries[].borders[].subregion").ignored(),
                        fieldWithPath("[].countries[].borders[].population").ignored(),
                        fieldWithPath("[].countries[].borders[].area").optional().ignored(),
                        fieldWithPath("[].countries[].borders[].alpha3Code").ignored(),
                        fieldWithPath("[].countries[].alpha3Code").description("Borders of the Country."))));
    }

    @Test
    void givenSubregionThenReturnCountryListAndPopulationCSV() throws Exception {

        //Given
        String subregion = "southamerica";
        List<SubregionDTO> subregionWrapper = allSouthAmericaJSONProvider();

        //When
        ResultActions result = mockMvc.perform(
                get("/api/v1/country/subregion/{subregion}/population", subregion)
                        .accept(TEXT_CSV))
                .andDo(document("v1/country/subregion/populationcsv",
                pathParameters(
                        parameterWithName("subregion").description("Region of desired list of countries to get."))));

        //Then
        result.andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(TEXT_CSV));
    }
}