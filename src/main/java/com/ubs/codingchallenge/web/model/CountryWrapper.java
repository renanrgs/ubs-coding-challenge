package com.ubs.codingchallenge.web.model;

import com.ubs.codingchallenge.web.dto.CountryDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
public class CountryWrapper extends ResourceWrapper<CountryDTO> implements Serializable {

    private static final long serialVersionUID = -4797796981862933941L;

    public CountryWrapper(List<CountryDTO> data) {
        super(data);
    }
}

