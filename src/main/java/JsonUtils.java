import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * @author sbaron
 * @since 6/30/16
 */
public class JsonUtils {

    public static <T> T parseJsonUsingJackson(String jsonAsString, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonAsString, clazz);
    }

    public static String objectToJsonUsingJackson(Object obj) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

    public static <T> T parseJsonUsingGson(String jsonAsString, Class<T> clazz) throws IOException {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(jsonAsString, clazz);
    }

    public static String objectToJsonUsingGson(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }
}
