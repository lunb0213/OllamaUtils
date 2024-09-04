package aland.ollamaUtils;

import aland.ollamaUtils.Map.ChatResultMap;
import aland.ollamaUtils.Map.GenerateResultMap;
import aland.ollamaUtils.Map.RequestMap;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class OllamaRequest {
    //请求URL
    private String url;
    JsonConvert jsonConvert;
    public OllamaRequest(String host, RequestWay way) {
        switch (way) {
            case GENERATE:
                this.url = host + "/api/generate";
                jsonConvert = new JsonConvert<GenerateResultMap>();
                break;
            case CHAT:
                this.url = host + "/api/chat";
                jsonConvert = new JsonConvert<ChatResultMap>();
                break;
            default:
                break;
        }
    }

    public <T> T request(RequestMap map, Class<T> cls) {
        String jsonBody = jsonConvert.map2Json(map);
        RestTemplate restTemplate = new RestTemplate();
        // 构建请求体
        HttpHeaders headers = new HttpHeaders();
        // 创建HttpHeaders实例并设置Content-Type为application/json
        headers.setContentType(MediaType.APPLICATION_JSON);
        // 创建HttpEntity对象，包含请求头和请求体
        HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);
        // 发送POST请求并接收响应
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
        // 打印响应体
        System.out.println(response.getBody());
        T rsm = (T) jsonConvert.json2Map(response.getBody(), cls);
        return rsm;
    }
}
