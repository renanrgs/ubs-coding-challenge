package com.ubs.codingchallenge.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ubs.codingchallenge.web.dto.CountryDTO;
import com.ubs.codingchallenge.web.dto.SubregionDTO;
import org.junit.jupiter.params.provider.Arguments;
import org.springframework.http.MediaType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestUtil {

    public static MediaType TEXT_CSV = new MediaType("text", "csv");

    public static Stream<Arguments> southAmericaCountriesProvider() {
        CountryDTO brazil = CountryDTO.builder().alpha3Code("BRA").build();
        CountryDTO argentina = CountryDTO.builder().alpha3Code("ARG").build();
        CountryDTO bolivia = CountryDTO.builder().alpha3Code("BOL").build();
        CountryDTO colombia = CountryDTO.builder().alpha3Code("COL").build();
        CountryDTO peru = CountryDTO.builder().alpha3Code("PER").build();
        CountryDTO suriname = CountryDTO.builder().alpha3Code("SUR").build();

        Arguments over3BordersCountries = Arguments.of(Arrays.asList(brazil, argentina,
                bolivia, colombia, peru, suriname));

        return Stream.of(over3BordersCountries);
    }

    public static List<CountryDTO> allSouthAmericaCountries() {
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

        return Arrays.asList(brazil, argentina, bolivia, colombia, peru,
                suriname, chile, ecuador, falkLandIsland, frenchGuiana, guiana, paraguay, southGeorgia, uruguay, venezuela);
    }

    public static Stream<Arguments> allSouthAmericaCountriesProvider() {
        Arguments allSouthAmericaCountries = Arguments.of(allSouthAmericaCountries());
        return Stream.of(allSouthAmericaCountries);
    }

    public static List<CountryDTO> oceaniaCountries() {
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

        return Arrays.asList(australia, papua, newZealand, solomonIslands,
                newCaledonia, fiji, vanuatu, frenchPolynesia, samoa, kiribati);
    }

    public static Stream<Arguments> oceaniaCountriesProvider() {
        Arguments oceaniaArguments = Arguments.of(oceaniaCountries());
        return Stream.of(oceaniaArguments);
    }

    public static List<CountryDTO> oceaniaCountryJSONProvider() throws JsonProcessingException {

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

    public static List<CountryDTO> southAmericaCountryJSONProvider() throws JsonProcessingException {
        String json = "[{\"name\":\"Argentina\",\"capital\":\"Buenos Aires\",\"region\":\"Americas\",\"subregion" +
                "\":\"South America\",\"population\":43590400,\"area\":2780400.0,\"borders\":[{\"name\":" +
                "\"Bolivia (Plurinational State of)\",\"capital\":\"Sucre\",\"region\":\"Americas\",\"subregion" +
                "\":\"South America\",\"population\":10985059,\"area\":1098581.0,\"alpha3Code\":\"BOL\"},{\"name" +
                "\":\"Brazil\",\"capital\":\"Brasília\",\"region\":\"Americas\",\"subregion\":\"South America" +
                "\",\"population\":206135893,\"area\":8515767.0,\"alpha3Code\":\"BRA\"},{\"name\":\"Chile\",\"capital" +
                "\":\"Santiago\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":18191900," +
                "\"area\":756102.0,\"alpha3Code\":\"CHL\"},{\"name\":\"Paraguay\",\"capital\":\"Asunción\",\"region" +
                "\":\"Americas\",\"subregion\":\"South America\",\"population\":6854536,\"area\":406752.0,\"alpha3Code" +
                "\":\"PRY\"},{\"name\":\"Uruguay\",\"capital\":\"Montevideo\",\"region\":\"Americas\",\"subregion\":" +
                "\"South America\",\"population\":3480222,\"area\":181034.0,\"alpha3Code\":\"URY\"}],\"alpha3Code\":" +
                "\"ARG\"},{\"name\":\"Bolivia (Plurinational State of)\",\"capital\":\"Sucre\",\"region\":\"Americas" +
                "\",\"subregion\":\"South America\",\"population\":10985059,\"area\":1098581.0,\"borders\":[{\"name" +
                "\":\"Argentina\",\"capital\":\"Buenos Aires\",\"region\":\"Americas\",\"subregion\":\"South America" +
                "\",\"population\":43590400,\"area\":2780400.0,\"alpha3Code\":\"ARG\"},{\"name\":\"Brazil\",\"capita" +
                "l\":\"Brasília\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population" +
                "\":206135893,\"area\":8515767.0,\"alpha3Code\":\"BRA\"},{\"name\":\"Chile\",\"capital\":\"Santiago" +
                "\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":18191900,\"area\":756102.0," +
                "\"alpha3Code\":\"CHL\"},{\"name\":\"Paraguay\",\"capital\":\"Asunción\",\"region\":\"Americas\"," +
                "\"subregion\":\"South America\",\"population\":6854536,\"area\":406752.0,\"alpha3Code\":\"PRY\"}," +
                "{\"name\":\"Peru\",\"capital\":\"Lima\",\"region\":\"Americas\",\"subregion\":\"South America\"," +
                "\"population\":31488700,\"area\":1285216.0,\"alpha3Code\":\"PER\"}],\"alpha3Code\":\"BOL\"}," +
                "{\"name\":\"Brazil\",\"capital\":\"Brasília\",\"region\":\"Americas\",\"subregion\":" +
                "\"South America\",\"population\":206135893,\"area\":8515767.0,\"borders\":[{\"name\":\"Argentina\"," +
                "\"capital\":\"Buenos Aires\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population" +
                "\":43590400,\"area\":2780400.0,\"alpha3Code\":\"ARG\"},{\"name\":\"Bolivia (Plurinational State of)" +
                "\",\"capital\":\"Sucre\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population" +
                "\":10985059,\"area\":1098581.0,\"alpha3Code\":\"BOL\"},{\"name\":\"Colombia\",\"capital\":\"Bogotá\"" +
                ",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":48759958,\"area\":1141748.0," +
                "\"alpha3Code\":\"COL\"},{\"name\":\"French Guiana\",\"capital\":\"Cayenne\",\"region\":\"Americas\"," +
                "\"subregion\":\"South America\",\"population\":254541,\"area\":null,\"alpha3Code\":\"GUF\"},{\"name\":" +
                "\"Guyana\",\"capital\":\"Georgetown\",\"region\":\"Americas\",\"subregion\":\"South America\",\"" +
                "population\":746900,\"area\":214969.0,\"alpha3Code\":\"GUY\"},{\"name\":\"Paraguay\",\"capital\":" +
                "\"Asunción\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":6854536,\"area" +
                "\":406752.0,\"alpha3Code\":\"PRY\"},{\"name\":\"Peru\",\"capital\":\"Lima\",\"region\":\"Americas\"," +
                "\"subregion\":\"South America\",\"population\":31488700,\"area\":1285216.0,\"alpha3Code\":\"PER\"}," +
                "{\"name\":\"Suriname\",\"capital\":\"Paramaribo\",\"region\":\"Americas\",\"subregion\":\"South America" +
                "\",\"population\":541638,\"area\":163820.0,\"alpha3Code\":\"SUR\"},{\"name\":\"Uruguay\",\"capital\":" +
                "\"Montevideo\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":3480222," +
                "\"area\":181034.0,\"alpha3Code\":\"URY\"},{\"name\":\"Venezuela (Bolivarian Republic of)\",\"capital" +
                "\":\"Caracas\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":31028700,\"" +
                "area\":916445.0,\"alpha3Code\":\"VEN\"}],\"alpha3Code\":\"BRA\"},{\"name\":\"Colombia\",\"capital" +
                "\":\"Bogotá\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":48759958,\"" +
                "area\":1141748.0,\"borders\":[{\"name\":\"Brazil\",\"capital\":\"Brasília\",\"region\":\"America" +
                "s\",\"subregion\":\"South America\",\"population\":206135893,\"area\":8515767.0,\"alpha3Code\":" +
                "\"BRA\"},{\"name\":\"Ecuador\",\"capital\":\"Quito\",\"region\":\"Americas\",\"subregion\":\"" +
                "South America\",\"population\":16545799,\"area\":276841.0,\"alpha3Code\":\"ECU\"},{\"name\":\"Panama\"" +
                ",\"capital\":\"Panama City\",\"region\":\"Americas\",\"subregion\":\"Central America\",\"population" +
                "\":3814672,\"area\":75417.0,\"alpha3Code\":\"PAN\"},{\"name\":\"Peru\",\"capital\":\"Lima\",\"region" +
                "\":\"Americas\",\"subregion\":\"South America\",\"population\":31488700,\"area\":1285216.0,\"alpha3Cod" +
                "e\":\"PER\"},{\"name\":\"Venezuela (Bolivarian Republic of)\",\"capital\":\"Caracas\",\"region\":" +
                "\"Americas\",\"subregion\":\"South America\",\"population\":31028700,\"area\":916445.0,\"alpha3Code" +
                "\":\"VEN\"}],\"alpha3Code\":\"COL\"},{\"name\":\"Peru\",\"capital\":\"Lima\",\"region\":\"Americas" +
                "\",\"subregion\":\"South America\",\"population\":31488700,\"area\":1285216.0,\"borders\":[{\"name\":\"" +
                "Bolivia (Plurinational State of)\",\"capital\":\"Sucre\",\"region\":\"Americas\",\"subregion\":" +
                "\"South America\",\"population\":10985059,\"area\":1098581.0,\"alpha3Code\":\"BOL\"},{\"name\":\"Brazil\"" +
                ",\"capital\":\"Brasília\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population" +
                "\":206135893,\"area\":8515767.0,\"alpha3Code\":\"BRA\"},{\"name\":\"Chile\",\"capital\":\"Santiago\"," +
                "\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":18191900,\"area\":756102.0," +
                "\"alpha3Code\":\"CHL\"},{\"name\":\"Colombia\",\"capital\":\"Bogotá\",\"region\":\"Americas\",\"subregion" +
                "\":\"South America\",\"population\":48759958,\"area\":1141748.0,\"alpha3Code\":\"COL\"},{\"name\":\"Ecuador" +
                "\",\"capital\":\"Quito\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":16545799," +
                "\"area\":276841.0,\"alpha3Code\":\"ECU\"}],\"alpha3Code\":\"PER\"},{\"name\":\"Suriname\",\"capital\":" +
                "\"Paramaribo\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":541638,\"area" +
                "\":163820.0,\"borders\":[{\"name\":\"Brazil\",\"capital\":\"Brasília\",\"region\":\"Americas\"," +
                "\"subregion\":\"South America\",\"population\":206135893,\"area\":8515767.0,\"alpha3Code\":\"BRA\"}," +
                "{\"name\":\"French Guiana\",\"capital\":\"Cayenne\",\"region\":\"Americas\",\"subregion\":\"South America" +
                "\",\"population\":254541,\"area\":null,\"alpha3Code\":\"GUF\"},{\"name\":\"France\",\"capital\":" +
                "\"Paris\",\"region\":\"Europe\",\"subregion\":\"Western Europe\",\"population\":66710000,\"area\":640679.0," +
                "\"alpha3Code\":\"FRA\"},{\"name\":\"Guyana\",\"capital\":\"Georgetown\",\"region\":\"Americas\"," +
                "\"subregion\":\"South America\",\"population\":746900,\"area\":214969.0,\"alpha3Code\":\"GUY\"}]," +
                "\"alpha3Code\":\"SUR\"}]";
        ObjectMapper mapper = new ObjectMapper();
        List<CountryDTO> countries = mapper.readValue(json, List.class);
        return countries;
    }

    public static List<SubregionDTO> allSouthAmericaJSONProvider() throws JsonProcessingException {
        String json = "[{\"totalPopulation\":418606839,\"countries\":[{\"name\":\"Argentina\",\"capital\":\"Buenos Aires\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":43590400,\"area\":2780400.0,\"borders\":[{\"name\":\"Bolivia (Plurinational State of)\",\"capital\":\"Sucre\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":10985059,\"area\":1098581.0,\"alpha3Code\":\"BOL\"},{\"name\":\"Brazil\",\"capital\":\"Brasília\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":206135893,\"area\":8515767.0,\"alpha3Code\":\"BRA\"},{\"name\":\"Chile\",\"capital\":\"Santiago\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":18191900,\"area\":756102.0,\"alpha3Code\":\"CHL\"},{\"name\":\"Paraguay\",\"capital\":\"Asunción\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":6854536,\"area\":406752.0,\"alpha3Code\":\"PRY\"},{\"name\":\"Uruguay\",\"capital\":\"Montevideo\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":3480222,\"area\":181034.0,\"alpha3Code\":\"URY\"}],\"alpha3Code\":\"ARG\"},{\"name\":\"Bolivia (Plurinational State of)\",\"capital\":\"Sucre\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":10985059,\"area\":1098581.0,\"borders\":[{\"name\":\"Argentina\",\"capital\":\"Buenos Aires\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":43590400,\"area\":2780400.0,\"alpha3Code\":\"ARG\"},{\"name\":\"Brazil\",\"capital\":\"Brasília\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":206135893,\"area\":8515767.0,\"alpha3Code\":\"BRA\"},{\"name\":\"Chile\",\"capital\":\"Santiago\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":18191900,\"area\":756102.0,\"alpha3Code\":\"CHL\"},{\"name\":\"Paraguay\",\"capital\":\"Asunción\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":6854536,\"area\":406752.0,\"alpha3Code\":\"PRY\"},{\"name\":\"Peru\",\"capital\":\"Lima\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":31488700,\"area\":1285216.0,\"alpha3Code\":\"PER\"}],\"alpha3Code\":\"BOL\"},{\"name\":\"Brazil\",\"capital\":\"Brasília\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":206135893,\"area\":8515767.0,\"borders\":[{\"name\":\"Argentina\",\"capital\":\"Buenos Aires\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":43590400,\"area\":2780400.0,\"alpha3Code\":\"ARG\"},{\"name\":\"Bolivia (Plurinational State of)\",\"capital\":\"Sucre\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":10985059,\"area\":1098581.0,\"alpha3Code\":\"BOL\"},{\"name\":\"Colombia\",\"capital\":\"Bogotá\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":48759958,\"area\":1141748.0,\"alpha3Code\":\"COL\"},{\"name\":\"French Guiana\",\"capital\":\"Cayenne\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":254541,\"area\":null,\"alpha3Code\":\"GUF\"},{\"name\":\"Guyana\",\"capital\":\"Georgetown\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":746900,\"area\":214969.0,\"alpha3Code\":\"GUY\"},{\"name\":\"Paraguay\",\"capital\":\"Asunción\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":6854536,\"area\":406752.0,\"alpha3Code\":\"PRY\"},{\"name\":\"Peru\",\"capital\":\"Lima\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":31488700,\"area\":1285216.0,\"alpha3Code\":\"PER\"},{\"name\":\"Suriname\",\"capital\":\"Paramaribo\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":541638,\"area\":163820.0,\"alpha3Code\":\"SUR\"},{\"name\":\"Uruguay\",\"capital\":\"Montevideo\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":3480222,\"area\":181034.0,\"alpha3Code\":\"URY\"},{\"name\":\"Venezuela (Bolivarian Republic of)\",\"capital\":\"Caracas\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":31028700,\"area\":916445.0,\"alpha3Code\":\"VEN\"}],\"alpha3Code\":\"BRA\"},{\"name\":\"Chile\",\"capital\":\"Santiago\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":18191900,\"area\":756102.0,\"borders\":[{\"name\":\"Argentina\",\"capital\":\"Buenos Aires\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":43590400,\"area\":2780400.0,\"alpha3Code\":\"ARG\"},{\"name\":\"Bolivia (Plurinational State of)\",\"capital\":\"Sucre\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":10985059,\"area\":1098581.0,\"alpha3Code\":\"BOL\"},{\"name\":\"Peru\",\"capital\":\"Lima\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":31488700,\"area\":1285216.0,\"alpha3Code\":\"PER\"}],\"alpha3Code\":\"CHL\"},{\"name\":\"Colombia\",\"capital\":\"Bogotá\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":48759958,\"area\":1141748.0,\"borders\":[{\"name\":\"Brazil\",\"capital\":\"Brasília\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":206135893,\"area\":8515767.0,\"alpha3Code\":\"BRA\"},{\"name\":\"Ecuador\",\"capital\":\"Quito\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":16545799,\"area\":276841.0,\"alpha3Code\":\"ECU\"},{\"name\":\"Panama\",\"capital\":\"Panama City\",\"region\":\"Americas\",\"subregion\":\"Central America\",\"population\":3814672,\"area\":75417.0,\"alpha3Code\":\"PAN\"},{\"name\":\"Peru\",\"capital\":\"Lima\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":31488700,\"area\":1285216.0,\"alpha3Code\":\"PER\"},{\"name\":\"Venezuela (Bolivarian Republic of)\",\"capital\":\"Caracas\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":31028700,\"area\":916445.0,\"alpha3Code\":\"VEN\"}],\"alpha3Code\":\"COL\"},{\"name\":\"Ecuador\",\"capital\":\"Quito\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":16545799,\"area\":276841.0,\"borders\":[{\"name\":\"Colombia\",\"capital\":\"Bogotá\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":48759958,\"area\":1141748.0,\"alpha3Code\":\"COL\"},{\"name\":\"Peru\",\"capital\":\"Lima\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":31488700,\"area\":1285216.0,\"alpha3Code\":\"PER\"}],\"alpha3Code\":\"ECU\"},{\"name\":\"Falkland Islands (Malvinas)\",\"capital\":\"Stanley\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":2563,\"area\":12173.0,\"borders\":[],\"alpha3Code\":\"FLK\"},{\"name\":\"French Guiana\",\"capital\":\"Cayenne\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":254541,\"area\":null,\"borders\":[{\"name\":\"Brazil\",\"capital\":\"Brasília\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":206135893,\"area\":8515767.0,\"alpha3Code\":\"BRA\"},{\"name\":\"Suriname\",\"capital\":\"Paramaribo\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":541638,\"area\":163820.0,\"alpha3Code\":\"SUR\"}],\"alpha3Code\":\"GUF\"},{\"name\":\"Guyana\",\"capital\":\"Georgetown\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":746900,\"area\":214969.0,\"borders\":[{\"name\":\"Brazil\",\"capital\":\"Brasília\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":206135893,\"area\":8515767.0,\"alpha3Code\":\"BRA\"},{\"name\":\"Suriname\",\"capital\":\"Paramaribo\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":541638,\"area\":163820.0,\"alpha3Code\":\"SUR\"},{\"name\":\"Venezuela (Bolivarian Republic of)\",\"capital\":\"Caracas\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":31028700,\"area\":916445.0,\"alpha3Code\":\"VEN\"}],\"alpha3Code\":\"GUY\"},{\"name\":\"Paraguay\",\"capital\":\"Asunción\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":6854536,\"area\":406752.0,\"borders\":[{\"name\":\"Argentina\",\"capital\":\"Buenos Aires\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":43590400,\"area\":2780400.0,\"alpha3Code\":\"ARG\"},{\"name\":\"Bolivia (Plurinational State of)\",\"capital\":\"Sucre\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":10985059,\"area\":1098581.0,\"alpha3Code\":\"BOL\"},{\"name\":\"Brazil\",\"capital\":\"Brasília\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":206135893,\"area\":8515767.0,\"alpha3Code\":\"BRA\"}],\"alpha3Code\":\"PRY\"},{\"name\":\"Peru\",\"capital\":\"Lima\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":31488700,\"area\":1285216.0,\"borders\":[{\"name\":\"Bolivia (Plurinational State of)\",\"capital\":\"Sucre\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":10985059,\"area\":1098581.0,\"alpha3Code\":\"BOL\"},{\"name\":\"Brazil\",\"capital\":\"Brasília\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":206135893,\"area\":8515767.0,\"alpha3Code\":\"BRA\"},{\"name\":\"Chile\",\"capital\":\"Santiago\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":18191900,\"area\":756102.0,\"alpha3Code\":\"CHL\"},{\"name\":\"Colombia\",\"capital\":\"Bogotá\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":48759958,\"area\":1141748.0,\"alpha3Code\":\"COL\"},{\"name\":\"Ecuador\",\"capital\":\"Quito\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":16545799,\"area\":276841.0,\"alpha3Code\":\"ECU\"}],\"alpha3Code\":\"PER\"},{\"name\":\"South Georgia and the South Sandwich Islands\",\"capital\":\"King Edward Point\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":30,\"area\":null,\"borders\":[],\"alpha3Code\":\"SGS\"},{\"name\":\"Suriname\",\"capital\":\"Paramaribo\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":541638,\"area\":163820.0,\"borders\":[{\"name\":\"Brazil\",\"capital\":\"Brasília\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":206135893,\"area\":8515767.0,\"alpha3Code\":\"BRA\"},{\"name\":\"French Guiana\",\"capital\":\"Cayenne\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":254541,\"area\":null,\"alpha3Code\":\"GUF\"},{\"name\":\"France\",\"capital\":\"Paris\",\"region\":\"Europe\",\"subregion\":\"Western Europe\",\"population\":66710000,\"area\":640679.0,\"alpha3Code\":\"FRA\"},{\"name\":\"Guyana\",\"capital\":\"Georgetown\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":746900,\"area\":214969.0,\"alpha3Code\":\"GUY\"}],\"alpha3Code\":\"SUR\"},{\"name\":\"Uruguay\",\"capital\":\"Montevideo\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":3480222,\"area\":181034.0,\"borders\":[{\"name\":\"Argentina\",\"capital\":\"Buenos Aires\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":43590400,\"area\":2780400.0,\"alpha3Code\":\"ARG\"},{\"name\":\"Brazil\",\"capital\":\"Brasília\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":206135893,\"area\":8515767.0,\"alpha3Code\":\"BRA\"}],\"alpha3Code\":\"URY\"},{\"name\":\"Venezuela (Bolivarian Republic of)\",\"capital\":\"Caracas\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":31028700,\"area\":916445.0,\"borders\":[{\"name\":\"Brazil\",\"capital\":\"Brasília\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":206135893,\"area\":8515767.0,\"alpha3Code\":\"BRA\"},{\"name\":\"Colombia\",\"capital\":\"Bogotá\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":48759958,\"area\":1141748.0,\"alpha3Code\":\"COL\"},{\"name\":\"Guyana\",\"capital\":\"Georgetown\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":746900,\"area\":214969.0,\"alpha3Code\":\"GUY\"}],\"alpha3Code\":\"VEN\"}]}]";

        ObjectMapper mapper = new ObjectMapper();
        List<SubregionDTO> subregion = mapper.readValue(json, List.class);
        return subregion;

    }
}
