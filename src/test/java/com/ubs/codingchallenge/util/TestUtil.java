package com.ubs.codingchallenge.util;

import com.ubs.codingchallenge.web.model.CountryDTO;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.stream.Stream;

public class TestUtil {
    public static Stream<Arguments> southAmericaCountriesProvider() {
        CountryDTO brazil = CountryDTO.builder().alpha3Code("BRA").build();
        CountryDTO argentina = CountryDTO.builder().alpha3Code("ARG").build();
        CountryDTO bolivia = CountryDTO.builder().alpha3Code("BOL").build();
        CountryDTO colombia = CountryDTO.builder().alpha3Code("COL").build();
        CountryDTO peru = CountryDTO.builder().alpha3Code("PER").build();
        CountryDTO suriname = CountryDTO.builder().alpha3Code("SUR").build();

        return Stream.of(Arguments.of(Arrays.asList(brazil, argentina, bolivia, colombia, peru, suriname)));
    }

    public static Stream<Arguments> oceaniaCountriesProvider() {
        CountryDTO australia = CountryDTO.builder().alpha3Code("AUS").build();
        CountryDTO papua = CountryDTO.builder().alpha3Code("PNG").build();
        CountryDTO newZealand = CountryDTO.builder().alpha3Code("NZL").build();
        CountryDTO solomonIslands = CountryDTO.builder().alpha3Code("SLB").build();
        CountryDTO newCaledonia = CountryDTO.builder().alpha3Code("NCL").build();
        CountryDTO fiji = CountryDTO.builder().alpha3Code("FJI").build();
        CountryDTO vanuatu = CountryDTO.builder().alpha3Code("VUT").build();
        CountryDTO frenchPolynesia = CountryDTO.builder().alpha3Code("PYF").build();
        CountryDTO samoa = CountryDTO.builder().alpha3Code("WSM").build();
        CountryDTO kiribati = CountryDTO.builder().alpha3Code("KIR").build();

        Arguments oceaniaArguments = Arguments.of(Arrays.asList(australia, papua, newZealand, solomonIslands,
                newCaledonia, fiji, vanuatu, frenchPolynesia, samoa, kiribati));

        return Stream.of(oceaniaArguments);
    }
}
