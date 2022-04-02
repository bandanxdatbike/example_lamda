package bandan.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.HashMap;
import java.util.Map;

// Handler value: example.Handler
public class ExampleHandler implements RequestHandler<Map<String, Object>, Map<String, Object>> {
//    public ExampleHandler() {
//    }

    @Override
    public Map<String, Object> handleRequest(Map<String, Object> input, Context context) {
        input.forEach((k, v) -> System.out.println(k + ": " + v));
        String envName = System.getenv("ENV_NAME");

        Map<String, Object> resp = new HashMap();
        resp.put("statusCode", 200);
        resp.put("body", "{\"\": \""+envName+"\", \"version\": \"1.0\"}");

        return resp;
    }
}