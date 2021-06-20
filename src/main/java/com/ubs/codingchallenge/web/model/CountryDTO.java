package com.ubs.codingchallenge.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CountryDTO {
    private String name;
    private String capital;
    private String region;
    private String subregion;
    private Long population;

    @JsonInclude(USE_DEFAULTS)
    private Double area;

    @JsonSerialize(using = CountrySerializer.class)
    @JsonInclude(NON_ABSENT)
    private List<CountryDTO> borders;
    private String alpha3Code;

    public CountryDTO(String alpha3Code){
        this.alpha3Code = alpha3Code;
    }
}
