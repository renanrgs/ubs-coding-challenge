package com.ubs.codingchallenge.converter;

import com.opencsv.CSVWriter;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.ubs.codingchallenge.web.model.ListParamDTO;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@Component
public class CsvHttpMessageConverter<T, L extends ListParamDTO<T>>
        extends AbstractHttpMessageConverter<L> {

    public CsvHttpMessageConverter () {
        super(new MediaType("text", "csv"));
    }

    @Override
    protected boolean supports (Class<?> clazz) {
        return ListParamDTO.class.isAssignableFrom(clazz);
    }

    @Override
    protected L readInternal (Class<? extends L> clazz, HttpInputMessage inputMessage)
            throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void writeInternal (L data, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {

        HeaderColumnNameMappingStrategy<T> strategy = new HeaderColumnNameMappingStrategy<>();
        strategy.setType(toBeanType(data.getClass().getGenericSuperclass()));

        OutputStreamWriter outputStream = new OutputStreamWriter(outputMessage.getBody());
        StatefulBeanToCsv<T> beanToCsv =
                new StatefulBeanToCsvBuilder(outputStream)

                        .withMappingStrategy(strategy)
                        .build();
        try {
            beanToCsv.write(data.getList());
            outputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    private Class<T> toBeanType (Type type) {
        return (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];
    }
}

