package com.ubs.codingchallenge.serializer;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.ubs.codingchallenge.web.model.CountryDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryCsvSerializer extends AbstractBeanField<CountryDTO, Integer> {

    @Override
    protected String convertToWrite(Object obj) {
        StringBuilder s = new StringBuilder();
        List<CountryDTO> countries =  (List<CountryDTO>)obj;
        s.append("[");
        countries.forEach(c -> {
            s.append(c.getAlpha3Code()).append(",");
        });
        s.replace(s.length(), s.length() + 1, "]");
        return s.toString();
    }

    @Override
    protected Object convert(String s) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        return null;
    }
}
