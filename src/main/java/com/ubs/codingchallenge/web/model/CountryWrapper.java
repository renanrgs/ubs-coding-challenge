package com.ubs.codingchallenge.web.model;

import com.ubs.codingchallenge.web.dto.CountryDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class CountryWrapper extends ResourceWrapper<CountryDTO> {

}

