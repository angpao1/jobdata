package com.example.jobdata.models.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Res implements Serializable, Cloneable {
    @Serial
    private static final long serialVersionUID = -4669785284490248064L;
    private String description;

    @JsonInclude(JsonInclude.Include.NON_NULL)

    @Override
    public Object clone()
            throws CloneNotSupportedException {
        return super.clone();
    }
}
