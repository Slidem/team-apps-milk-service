package com.teamapps.milkservice.rest.annotation;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @author Mihai Alexandru
 * @date 24.12.2018
 */
public class IdSerializer extends JsonSerializer<Integer> {

    @Override
    public void serialize(Integer id, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(IdEncodingUtil.encode(id));
    }
}
