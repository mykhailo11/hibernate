package com.aimprosoft.departments.utils.impl;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperFactory {

    private static ObjectMapper mapper;

    private ObjectMapperFactory(){}
    public static ObjectMapper getMapper(){
        if (mapper == null){
            mapper = new ObjectMapper();
        }
        return mapper;
    }
}
