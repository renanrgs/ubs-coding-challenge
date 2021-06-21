package com.ubs.codingchallenge.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ubs.codingchallenge.web.dto.CountryDTO;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestUtil {
    public static Stream<Arguments> southAmericaCountriesProvider() {
        CountryDTO brazil = CountryDTO.builder().alpha3Code("BRA").build();
        CountryDTO argentina = CountryDTO.builder().alpha3Code("ARG").build();
        CountryDTO bolivia = CountryDTO.builder().alpha3Code("BOL").build();
        CountryDTO colombia = CountryDTO.builder().alpha3Code("COL").build();
        CountryDTO peru = CountryDTO.builder().alpha3Code("PER").build();
        CountryDTO chile = CountryDTO.builder().alpha3Code("CHL").build();
        CountryDTO ecuador = CountryDTO.builder().alpha3Code("ECU").build();
        CountryDTO falkLandIsland = CountryDTO.builder().alpha3Code("FLK").build();
        CountryDTO frenchGuiana = CountryDTO.builder().alpha3Code("GUF").build();
        CountryDTO guiana = CountryDTO.builder().alpha3Code("GUY").build();
        CountryDTO paraguay = CountryDTO.builder().alpha3Code("PRY").build();
        CountryDTO southGeorgia = CountryDTO.builder().alpha3Code("SGS").build();
        CountryDTO uruguay = CountryDTO.builder().alpha3Code("URY").build();
        CountryDTO venezuela = CountryDTO.builder().alpha3Code("VEN").build();
        CountryDTO suriname = CountryDTO.builder().alpha3Code("SUR").build();

        Arguments over3BordersCountries = Arguments.of(Arrays.asList(brazil, argentina,
                bolivia, colombia, peru, suriname));
        Arguments allSouthAmericaCountries = Arguments.of(Arrays.asList(brazil, argentina, bolivia, colombia, peru,
                suriname, chile, ecuador, falkLandIsland, frenchGuiana, guiana, paraguay, southGeorgia, uruguay, venezuela));

        return Stream.of(over3BordersCountries);
    }

    public static Stream<Arguments> allSouthAmericaCountriesProvider() {
        CountryDTO brazil = CountryDTO.builder().alpha3Code("BRA").build();
        CountryDTO argentina = CountryDTO.builder().alpha3Code("ARG").build();
        CountryDTO bolivia = CountryDTO.builder().alpha3Code("BOL").build();
        CountryDTO colombia = CountryDTO.builder().alpha3Code("COL").build();
        CountryDTO peru = CountryDTO.builder().alpha3Code("PER").build();
        CountryDTO chile = CountryDTO.builder().alpha3Code("CHL").build();
        CountryDTO ecuador = CountryDTO.builder().alpha3Code("ECU").build();
        CountryDTO falkLandIsland = CountryDTO.builder().alpha3Code("FLK").build();
        CountryDTO frenchGuiana = CountryDTO.builder().alpha3Code("GUF").build();
        CountryDTO guiana = CountryDTO.builder().alpha3Code("GUY").build();
        CountryDTO paraguay = CountryDTO.builder().alpha3Code("PRY").build();
        CountryDTO southGeorgia = CountryDTO.builder().alpha3Code("SGS").build();
        CountryDTO uruguay = CountryDTO.builder().alpha3Code("URY").build();
        CountryDTO venezuela = CountryDTO.builder().alpha3Code("VEN").build();
        CountryDTO suriname = CountryDTO.builder().alpha3Code("SUR").build();

        Arguments allSouthAmericaCountries = Arguments.of(Arrays.asList(brazil, argentina, bolivia, colombia, peru,
                suriname, chile, ecuador, falkLandIsland, frenchGuiana, guiana, paraguay, southGeorgia, uruguay, venezuela));

        return Stream.of(allSouthAmericaCountries);
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

    public static List<CountryDTO> oceaniaCountryWrapperPovider() throws JsonProcessingException {

        String json = "[{\"name\":\"Australia\",\"capital\":\"Canberra\",\"region\":\"Oceania\",\"subregion" +
                "\":\"Australia and New Zealand\",\"population\":24117360,\"area\":7692024.0,\"borders\":[]," +
                "\"alpha3Code\":\"AUS\"},{\"name\":\"Papua New Guinea\",\"capital\":\"Port Moresby\",\"region\"" +
                ":\"Oceania\",\"subregion\":\"Melanesia\",\"population\":8083700,\"area\":462840.0,\"borders" +
                "\":[{\"name\":\"Indonesia\",\"capital\":\"Jakarta\",\"region\":\"Asia\",\"subregion\":" +
                "\"South-Eastern Asia\",\"population\":258705000,\"area\":1904569.0,\"alpha3Code\":\"IDN" +
                "\"}],\"alpha3Code\":\"PNG\"},{\"name\":\"New Zealand\",\"capital\":\"Wellington\",\"region" +
                "\":\"Oceania\",\"subregion\":\"Australia and New Zealand\",\"population\":4697854,\"area" +
                "\":270467.0,\"borders\":[],\"alpha3Code\":\"NZL\"},{\"name\":\"Solomon Islands\"," +
                "\"capital\":\"Honiara\",\"region\":\"Oceania\",\"subregion\":\"Melanesia\",\"population" +
                "\":642000,\"area\":28896.0,\"borders\":[],\"alpha3Code\":\"SLB\"},{\"name\":\"New Caledonia" +
                "\",\"capital\":\"Nouméa\",\"region\":\"Oceania\",\"subregion\":\"Melanesia\"," +
                "\"population\":268767,\"area\":18575.0,\"borders\":[],\"alpha3Code\":\"NCL\"},{\"name\":" +
                "\"Fiji\",\"capital\":\"Suva\",\"region\":\"Oceania\",\"subregion\":\"Melanesia\",\"population" +
                "\":867000,\"area\":18272.0,\"borders\":[],\"alpha3Code\":\"FJI\"},{\"name\":\"Vanuatu\",\"capital" +
                "\":\"Port Vila\",\"region\":\"Oceania\",\"subregion\":\"Melanesia\",\"population\":277500," +
                "\"area\":12189.0,\"borders\":[],\"alpha3Code\":\"VUT\"},{\"name\":\"French Polynesia\",\"capital" +
                "\":\"Papeetē\",\"region\":\"Oceania\",\"subregion\":\"Polynesia\",\"population\":271800,\"area" +
                "\":4167.0,\"borders\":[],\"alpha3Code\":\"PYF\"},{\"name\":\"Samoa\",\"capital\":\"Apia\",\"region" +
                "\":\"Oceania\",\"subregion\":\"Polynesia\",\"population\":194899,\"area\":2842.0,\"borders\":[]" +
                ",\"alpha3Code\":\"WSM\"},{\"name\":\"Kiribati\",\"capital\":\"South Tarawa\",\"region\":\"Oceania" +
                "\",\"subregion\":\"Micronesia\",\"population\":113400,\"area\":811.0,\"borders\":[],\"alpha3Code" +
                "\":\"KIR\"}]";
        ObjectMapper mapper = new ObjectMapper();
        List<CountryDTO> countries = mapper.readValue(json, List.class);
        return countries;
    }
}
