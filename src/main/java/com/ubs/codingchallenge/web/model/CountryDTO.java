package com.ubs.codingchallenge.web.model;

import lombok.*;

import java.util.List;

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
    private Double area;
    private List<CountryDTO> borders;
    private String alpha3Code;

    public CountryDTO(String alpha3Code){
        this.alpha3Code = alpha3Code;
    }
}
