# OllamaUtils

## Example：
generate api:
```java
String msg = "Hello Ollama!";
String result = null;
OllamaRequest qr = new OllamaRequest("http://localhost:11434", RequestWay.GENERATE);
GenerateRequestMap qrm = new GenerateRequestMap();
qrm.setPrompt(msg);
GenerateResultMap grm = qr.request(qrm, GenerateResultMap.class);

result = grm.getResponse();//LLM answer
```
chat api:
```java
String msg = "Hello Ollama!";
String result = null;
OllamaRequest qr = new OllamaRequest("http://localhost:11434", RequestWay.CHAT);
ChatRequestMap crm = new ChatRequestMap();
crm.setPrompt(msg);
GenerateResultMap grm = qr.request(crm, ChatResultMap.class);

result = grm.getMassage().get(0).get("content");//LLM answer
```
RequestWay types: 
- GENERATE
- CHAT

## Referenced libraries
- jackson 2.15.2
- spring-webmvc 5.2.8 --- (Mainly used for HTTP requests, there should be a better solution)
