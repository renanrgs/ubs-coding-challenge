package com.ubs.codingchallenge.web.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResourceWrapper<T> implements Serializable {

    private static final long serialVersionUID = -7427694300130301744L;
    @JsonValue
    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
