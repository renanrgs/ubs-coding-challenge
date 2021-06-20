package com.ubs.codingchallenge.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import com.ubs.codingchallenge.converter.CountryCsvConverter;
import com.ubs.codingchallenge.serializer.CountryJSONSerializer;
import lombok.*;

import java.io.Serializable;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_ABSENT;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CountryDTO implements Serializable {
    private static final long serialVersionUID = -9166309952260519990L;

    @CsvBindByName
    private String name;

    @CsvBindByName
    private String capital;

    @CsvBindByName
    private String region;

    @CsvBindByName
    private String subregion;

    @CsvBindByName
    private Long population;

    @CsvBindByName
    private Double area;

    @JsonSerialize(using = CountryJSONSerializer.class)
    @JsonInclude(NON_ABSENT)
    @CsvCustomBindByName(converter = CountryCsvConverter.class)
    private List<CountryDTO> borders;
    private String alpha3Code;

    public CountryDTO(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }
}
