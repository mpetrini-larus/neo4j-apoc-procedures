package apoc.ml;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.Map;

import static apoc.ml.MLUtil.MODEL_CONF_KEY;
import static apoc.ml.OpenAI.API_TYPE_CONF_KEY;
import static apoc.ml.OpenAIRequestHandler.Type.ANTHROPIC;
import static apoc.ml.OpenAITestResultUtils.CHAT_COMPLETION_QUERY_WITHOUT_SYSTEM;
import static apoc.util.TestUtil.testCall;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(Enclosed.class)
public class OpenAiAnthropicIT {

    public static class OpenAiAnthropicITVersion37 extends OpenAiAnthropicBaseIT{

        public static final String claude_sonnet = "claude-3-7-sonnet-20250219";

        @Override
        String getDefModel() {
            return claude_sonnet;
        }
    }

    public static class OpenAiAnthropicITVersion31 extends OpenAiAnthropicBaseIT{

        public static final String claude_sonnet = "claude-3-haiku-20240307";

        @Override
        String getDefModel() {
            return claude_sonnet;
        }

        @Test
        public void completionWithAnthropicNonDefaultModel() {
            Map<String, Object> conf = Map.of(
                    API_TYPE_CONF_KEY, ANTHROPIC.name(),
                    MODEL_CONF_KEY, getDefModel()
            );
            testCall(db, CHAT_COMPLETION_QUERY_WITHOUT_SYSTEM,
                    Map.of("conf", conf, "apiKey", anthropicApiKey),
                    (row) -> {
                        var result = (Map<String,Object>) row.get("value");
                        var contentList = (List<Map<String, Object>>) result.get("content");
                        Map<String, Object> content = contentList.get(0);
                        String generatedText = (String) content.get("text");
                        assertTrue(generatedText.toLowerCase().contains("earth"),
                                "Actual generatedText is " + generatedText);
                    });
        }
    }

}
