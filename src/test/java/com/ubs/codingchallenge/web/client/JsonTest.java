package com.ubs.codingchallenge.web.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ubs.codingchallenge.web.dto.CountryDTO;
import org.junit.jupiter.api.Test;

public class JsonTest {

    @Test
    public void jsonTest() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"name\":\"Åland Islands\",\"capital\":\"Mariehamn\",\"region\":\"Europe\",\"subregion\":\"Northern Europe\",\"population\":28875,\"area\":1580.0,\"borders\":[]}";

        CountryDTO c = mapper.readValue(json, CountryDTO.class);


    }
}
