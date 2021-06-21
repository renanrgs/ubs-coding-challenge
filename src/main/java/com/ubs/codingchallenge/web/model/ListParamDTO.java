package com.ubs.codingchallenge.web.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ListParamDTO<T> {

    @JsonValue
    private List<T> list;

    public List<T> getList () {
        return list;
    }

    public void setList (List<T> list) {
        this.list = list;
    }

}
