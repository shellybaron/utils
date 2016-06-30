import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * @author sbaron
 * @since 6/30/16
 */
public class JsonUtilsTest {

    String jsonStr = null;

    @Before
    public void init() throws IOException {
        InputStream is = JsonUtilsTest.class.getResourceAsStream("/jsonToParse.json");
        jsonStr = IOUtils.toString(is);
    }

    @Test
    public void jsonToObjectUsingJacksonTest() throws IOException {

        User user = JsonUtils.parseJsonUsingJackson(jsonStr, User.class);

        assertEquals(user.getId(), 1);
        assertEquals(user.getName(), "shelly");
        assertEquals(user.getEmail(), "shelly@gmail.com");
    }

    @Test
    public void jsonToObjectUsingGsonTest() throws IOException {

        User user = JsonUtils.parseJsonUsingGson(jsonStr, User.class);

        assertEquals(user.getId(), 1);
        assertEquals(user.getName(), "shelly");
        assertEquals(user.getEmail(), "shelly@gmail.com");
    }


    @Test
    public void objectToJsonUsingGsonTest() throws IOException, JSONException {

        User user = new User();
        user.setId(1);
        user.setName("shelly");
        user.setEmail("shelly@gmail.com");

        JSONObject json = new JSONObject(JsonUtils.objectToJsonUsingGson(user));

        assertEquals(json.getInt("id"), 1);
        assertEquals(json.getString("name"), "shelly");
        assertEquals(json.getString("email"), "shelly@gmail.com");
    }

    @Test
    public void objectToJsonUsingJacksonTest() throws IOException, JSONException {

        User user = new User();
        user.setId(1);
        user.setName("shelly");
        user.setEmail("shelly@gmail.com");

        JSONObject json = new JSONObject(JsonUtils.objectToJsonUsingJackson(user));

        assertEquals(json.getInt("id"), 1);
        assertEquals(json.getString("name"), "shelly");
        assertEquals(json.getString("email"), "shelly@gmail.com");
    }


}
