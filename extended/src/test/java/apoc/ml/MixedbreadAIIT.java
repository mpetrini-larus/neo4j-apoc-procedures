package apoc.ml;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Map;

import static apoc.ml.MLUtil.MODEL_CONF_KEY;
import static apoc.util.TestUtil.testResult;
import static apoc.util.Util.map;
import static org.junit.Assert.assertFalse;

@RunWith(Enclosed.class)
public class MixedbreadAIIT {

    public static class MixedbreadAITembedV1 extends MixedbreadAiBaseIT{

        public static final String MBREAD_MODEL = "mxbai-embed-2d-large-v1";

        @Override
        String getDefModel() {
            return MBREAD_MODEL;
        }



        @Test
        public void getEmbeddingWithOtherModel() {
            testResult(db, "CALL apoc.ml.mixedbread.embedding(['Some Text', 'Other Text'], $apiKey, $conf)",
                    map("apiKey", getApiKey(), "conf", map(MODEL_CONF_KEY, getDefModel())),
                    r -> {
                        Map<String, Object> row = r.next();
                        assertEmbedding(row, 0L, "Some Text", 1024);

                        row = r.next();
                        assertEmbedding(row, 1L, "Other Text", 1024);

                        assertFalse(r.hasNext());
                    });
        }
    }

    public static class MixedbreadAITrerankV1 extends MixedbreadAiBaseIT{

        public static final String MBREAD_MODEL = "mixedbread-ai/mxbai-rerank-large-v1";

        @Override
        String getDefModel() {
            return MBREAD_MODEL;
        }
    }

    public static class MixedbreadAITrerankV2 extends MixedbreadAiBaseIT{

        public static final String MBREAD_MODEL = "mixedbread-ai/mxbai-rerank-large-v2";

        @Override
        String getDefModel() {
            return MBREAD_MODEL;
        }
    }

}
