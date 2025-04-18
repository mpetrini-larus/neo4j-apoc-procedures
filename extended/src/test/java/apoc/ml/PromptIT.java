package apoc.ml;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.Map;

import static apoc.ml.MLUtil.MODEL_CONF_KEY;
import static apoc.ml.OpenAI.GPT_4O_MODEL;
import static apoc.ml.Prompt.API_KEY_CONF;
import static apoc.ml.Prompt.UNKNOWN_ANSWER;
import static apoc.util.MapUtil.map;
import static apoc.util.TestUtil.testCall;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Enclosed.class)
public class PromptIT {

    public static class PromptITVersion4 extends PromptBaseIT{

        public static final String GPT_41_MODEL = "gpt-4.1";

        @Override
        String getDefModel() {
            return GPT_41_MODEL;
        }
    }

    public static class PromptITVersion3 extends PromptBaseIT{

        public static final String GPT_35_MODEL = "gpt-3.5-turbo";

        @Override
        String getDefModel() {
            return GPT_35_MODEL;
        }

        @Test
        public void ragWithRelevantAttributesComparedToIrrelevantOneAndChatProcedure() {
            ragWithRelevantAttributesCommon(Map.of());
        }

        @Test
        public void ragWithRelevantAttributesComparedToIrrelevantOneAndChatProcedureGpt35Turbo() {
            ragWithRelevantAttributesCommon(Map.of(MODEL_CONF_KEY, GPT_35_MODEL));
        }

        private void ragWithRelevantAttributesCommon(Map<String, Object> config) {
            String question = "Which athletes won the gold medal in mixed doubles's curling  at the 2022 Winter Olympics?";

            // -- test with hallucinations, wrong winner names
            testCall(db, """
                CALL apoc.ml.openai.chat([
                    {role:"user", content: $question}
                ], $apiKey, $conf)""",
                    map("apiKey", OPENAI_KEY, "question", question, "conf", config),
                    r -> {
                        var result = (Map<String,Object>) r.get("value");

                        Map message = ((List<Map<String,Map>>) result.get("choices")).get(0).get("message");
                        assertEquals("assistant", message.get("role"));
                        String value = (String) message.get("content");

                        String msg = "Current value is: " + value;
                        assertTrue(msg, value.contains("gold medal"));
                        if (config.getOrDefault(MODEL_CONF_KEY, GPT_4O_MODEL).equals(GPT_35_MODEL)) {
                            assertNot2022Winners(value);
                        } else {
                            // with gpt-40 the info are updated, so the 2022 winners are known withuout RAG
                            assert2022Winners(value);
                        }
                    });

            // -- test RAG with irrelevant attributes
            testCall(db, QUERY_RAG,
                    map("attributes", List.of("irrelevant", "irrelevant2"),
                            "question", "Which athletes won the gold medal in curling at the 2022 Winter Olympics?",
                            "conf", config.isEmpty() ? map(API_KEY_CONF, OPENAI_KEY) : map(API_KEY_CONF, OPENAI_KEY, MODEL_CONF_KEY, config.get(MODEL_CONF_KEY))
                    ),
                    (r) -> {
                        String value = (String) r.get("value");
                        String message = "Current value is: " + value;
                        assertTrue(message, value.contains(UNKNOWN_ANSWER));
                        assertNot2022Winners(value);
                    });

            // -- test RAG with relevant attributes
            testCall(db, QUERY_RAG,
                    map(
                            "attributes", RAG_ATTRIBUTES,
                            "question", "Which athletes won the gold medal in curling at the 2022 Winter Olympics?",
                            "conf", config.isEmpty() ? map(API_KEY_CONF, OPENAI_KEY) : map(API_KEY_CONF, OPENAI_KEY, MODEL_CONF_KEY, config.get(MODEL_CONF_KEY))
                    ),
                    (r) -> {
                        String value = (String) r.get("value");
                        assert2022Winners(value);
                    });
        }
    }

}
