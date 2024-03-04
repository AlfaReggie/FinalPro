package org.exhandl.homework3.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;

public final class JsonUtils {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    private static final String JSON_FILE_FORMAT = ".json";

    public static <T> void saveAsJsonFile(String path, T object) throws IOException {
        if (object == null) {
            return;
        }

        if (!path.contains(JSON_FILE_FORMAT)) {
            path += JSON_FILE_FORMAT;
        }
        OBJECT_MAPPER.writeValue(new File(path), object);
    }

}
