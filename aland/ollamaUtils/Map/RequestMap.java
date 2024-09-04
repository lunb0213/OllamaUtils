package aland.ollamaUtils.Map;

import java.util.HashMap;
import java.util.Map;

public class RequestMap extends OllamaMap {
    protected Boolean stream;
    protected Map<String, Object> options;

    {
        stream = false;
        options = new HashMap<>();
    }

    public Boolean getStream() {
        return stream;
    }

    public void setStream(Boolean stream) {
        this.stream = stream;
    }

    public Map<String, Object> getOptions() {
        return options;
    }

    public void setOptions(Map<String, Object> options) {
        this.options = options;
    }
}
