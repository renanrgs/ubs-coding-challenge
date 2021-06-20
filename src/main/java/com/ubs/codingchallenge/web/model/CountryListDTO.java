package com.ubs.codingchallenge.web.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class CountryListDTO extends ListParamDTO<CountryDTO>{

    public CountryListDTO(List<CountryDTO> list) {
        super(list);
    }
}

