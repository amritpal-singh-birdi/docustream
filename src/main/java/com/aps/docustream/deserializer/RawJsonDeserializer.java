package com.aps.docustream.deserializer;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class RawJsonDeserializer extends JsonDeserializer<ObjectNode> {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public ObjectNode deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return (ObjectNode) mapper.readTree(p);
    }
}