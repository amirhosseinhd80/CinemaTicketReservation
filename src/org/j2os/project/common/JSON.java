package org.j2os.project.common;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JSON {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static String getString(Object o) throws IOException {
        return OBJECT_MAPPER.writeValueAsString(o);
    }


}
