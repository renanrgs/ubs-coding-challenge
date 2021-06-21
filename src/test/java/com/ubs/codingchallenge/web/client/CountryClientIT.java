package com.ubs.codingchallenge.web.client;

import com.ubs.codingchallenge.web.dto.CountryDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest
class CountryClientIT {

    @Autowired
    private CountryClient client;

    @Test
    void testFindAll(){
        List<CountryDTO> countries = client.findAll();
        assertThat(countries, notNullValue());
    }

}