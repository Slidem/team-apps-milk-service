package com.teamapps.milkservice.rest.annotation;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * @author Mihai Alexandru
 * @date 24.12.2018
 */
public class IdDeserializer extends JsonDeserializer<Integer> {

    @Override
    public Integer deserialize(JsonParser jsonParser, com.fasterxml.jackson.databind.DeserializationContext deserializationContext) throws IOException, com.fasterxml.jackson.core.JsonProcessingException {
        String encodedId = jsonParser.getText();
        return IdEncodingUtil.decode(encodedId);
    }
}
