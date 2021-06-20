package com.ubs.codingchallenge.config;

import com.ubs.codingchallenge.converter.CsvHttpMessageConverter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@EnableWebMvc
@ComponentScan("com.ubs.codingchallenge")
public class CsvMessageConfig implements WebMvcConfigurer {

    private final CsvHttpMessageConverter csvHttpMessageConverter;

    public CsvMessageConfig(CsvHttpMessageConverter csvHttpMessageConverter) {
        this.csvHttpMessageConverter = csvHttpMessageConverter;
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters){
        converters.add(csvHttpMessageConverter);
    }
}
