package aland.ollamaUtils.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
{
        "model": "llama3",
        "messages":
            [
                {
                    "role": "user",
                    "content": "why is the sky blue?"
                }
            ],
        "stream": false
        }
*/
public class ChatRequestMap extends RequestMap {

    private List<Map<String, Object>> messages;

    {
        messages = new ArrayList<>();
        messages.add(new HashMap<>());
        messages.get(0).put("role", "user");
        messages.get(0).put("content", "");
        options.put("seed", 42);
        options.put("temperature", 0.8);
    }

    public List<Map<String, Object>> getMessages() {
        return messages;
    }

    public void setMessages(List<Map<String, Object>> messages) {
        this.messages = messages;
    }

    public void setContent(String content) {
        messages.get(0).put("content", content);
    }

}
