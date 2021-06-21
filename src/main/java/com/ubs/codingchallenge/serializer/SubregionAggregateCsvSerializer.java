package com.ubs.codingchallenge.serializer;

import com.opencsv.bean.AbstractBeanField;
import com.ubs.codingchallenge.web.dto.CountryDTO;

import java.util.List;

public class SubregionAggregateCsvSerializer extends AbstractBeanField<CountryDTO, Long>{

    private static final String newLineChar = "\n";

    @Override
    protected Object convert(String s) {
        //TODO - Deserialize
        return null;
    }

    @Override
    protected String convertToWrite(Object obj) {
        final StringBuilder data = new StringBuilder();
        List<CountryDTO> countries =  (List<CountryDTO>)obj;
        countries.forEach(c -> {
            data.append("Name;").append(c.getName()).append("|")
                    .append("Capital;").append(c.getCapital()).append("|")
                    .append("Alpha3Code;").append(c.getAlpha3Code()).append("|")
                    .append("Subregion;").append(c.getSubregion()).append("|")
                    .append("Region;").append(c.getRegion()).append("|")
                    .append("Area;").append(c.getArea()).append("|")
                    .append("Population;").append(c.getPopulation()).append("|").append(newLineChar);
            data.append('[');
            c.getBorders().forEach(border -> {
                data.append(border.getAlpha3Code()).append("|");
            });
            data.append(']');
        });

        return data.toString();
    }
}
