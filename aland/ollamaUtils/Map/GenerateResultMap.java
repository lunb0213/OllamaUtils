package aland.ollamaUtils.Map;

import java.util.List;

public class GenerateResultMap extends ResultMap {
    private String response;
    private List<Long> context;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public List<Long> getContext() {
        return context;
    }

    public void setContext(List<Long> context) {
        this.context = context;
    }
}
