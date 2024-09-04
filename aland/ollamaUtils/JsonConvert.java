package aland.ollamaUtils;

import aland.ollamaUtils.Map.OllamaMap;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConvert<T> {

    public String map2Json(OllamaMap map) {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonBody;
        try {
            // 将对象序列化为JSON字符串
            jsonBody = objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
        return jsonBody;
    }

    public T json2Map(String jsonBody, Class<T> cls) {
        ObjectMapper objectMapper = new ObjectMapper();
        T map;
        try {
            // 将JSON字符串反序列化为对象
            map = objectMapper.readValue(jsonBody, cls);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
        return map;
    }

}
