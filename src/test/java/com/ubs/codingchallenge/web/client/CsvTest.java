package com.ubs.codingchallenge.web.client;

import com.ubs.codingchallenge.web.dto.CountryDTO;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class CsvTest {

    @Test
    public void testCsv() throws IOException {
        CountryDTO border1 = CountryDTO.builder().name("Paraguay").build();
        CountryDTO border2 = CountryDTO.builder().name("Argentina").build();
        CountryDTO border3 = CountryDTO.builder().name("Colombia").build();
        List<CountryDTO> borders = Arrays.asList(border1, border2, border3);
        CountryDTO country = CountryDTO.builder()
                .population(123L)
                .region("Americas")
                .name("Brazil")
                .alpha3Code("BRA")
                .capital("Brasilia")
                .area(BigDecimal.valueOf(1234.0))
                .subregion("South America").borders(borders)
                .build();

    }
}
