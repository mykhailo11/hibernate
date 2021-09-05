package com.aimprosoft.departments.entities;

import com.aimprosoft.departments.utils.impl.ObjectMapperFactory;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractEntity implements Entity {

    @Override
    public String toString(){
        try {
            ObjectMapper mapper = ObjectMapperFactory.getMapper();
            return mapper.writeValueAsString(this);
        }catch (JsonProcessingException jsonException){
            System.out.println(jsonException.getMessage());
            return super.toString();
        }
    }
}
