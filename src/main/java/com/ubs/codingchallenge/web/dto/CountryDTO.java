package com.ubs.codingchallenge.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import com.ubs.codingchallenge.serializer.json.CountryBorderJsonSerializer;
import com.ubs.codingchallenge.serializer.csv.CountryCsvSerializer;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_ABSENT;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(of = {"alpha3Code"})
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
    private BigDecimal area;

    @JsonSerialize(using = CountryBorderJsonSerializer.class)
    @JsonInclude(NON_ABSENT)
    @CsvCustomBindByName(converter = CountryCsvSerializer.class)
    private List<CountryDTO> borders;

    @CsvBindByName
    private String alpha3Code;

    public CountryDTO(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

}
