package com.ubs.codingchallenge.web.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RegionDTO {

    EUROPE ("Europe"),
    AMERICAS("Americas"),
    ASIA ("Asia"),
    OCEANIA("Oceania"),
    AFRICA("Africa"),
    POLAR("Polar");

    @JsonValue
    private final String region;

    RegionDTO(String region) {
        this.region = region;
    }
}
