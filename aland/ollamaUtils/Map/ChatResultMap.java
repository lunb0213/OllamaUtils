package aland.ollamaUtils.Map;

import java.util.List;
import java.util.Map;

public class ChatResultMap extends ResultMap {
    private List<Map<String, Object>> message;

    public List<Map<String, Object>> getMessage() {
        return message;
    }

    public void setMessage(List<Map<String, Object>> message) {
        this.message = message;
    }
}
