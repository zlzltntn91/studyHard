package thirdParyTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LibraryTestJacksonGson {

    public static void main(String[] args) throws IOException {
        ObjectMapper obm = new ObjectMapper();
        /** Json문자열 -> Map */
        String jsonStr = "{ \"name\" : \"민\" , \"age\" : 28 }";
        Map<String, Object> map = new HashMap<String, Object>();
//        map = obm.readValue(jsonStr, new TypeReference<Map<String, Object>>()  {});
        map = obm.readValue(jsonStr, new TypeReference<Map<String, Object>>() {
        });
        System.out.println("jsonString -> map : " + map);
        map = obm.readValue(jsonStr, Map.class);
        System.out.println(map);
        /**Map -> Json문자열 */
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("name", "미니미니");
        map2.put("age", 100);
        System.out.println(obm.writeValueAsString(map2));

        JsonObject jObj = new JsonObject();

        String jsonStr2 = obm.writerWithDefaultPrettyPrinter().writeValueAsString(map2);
//        System.out.println("map -> jsonString : " + jsonStr2);
    }
}
