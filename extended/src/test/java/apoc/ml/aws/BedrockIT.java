package apoc.ml.aws;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class BedrockIT {

    public static class BedrockITTVersionTitanV1 extends BedrockBaseIT {

        public static final String GEMINI_15 = "amazon.titan-embed-text-v1";

        @Override
        String getDefModel() {
            return GEMINI_15;
        }
    }

    public static class BedrockITTVersionTitanV2 extends BedrockBaseIT {

        public static final String GEMINI_15 = "amazon.titan-embed-text-v2:0";

        @Override
        String getDefModel() {
            return GEMINI_15;
        }
    }

    public static class BedrockITTVersionNovaV1 extends BedrockBaseIT {

        public static final String GEMINI_15 = "us.amazon.nova-pro-v1:0";

        @Override
        String getDefModel() {
            return GEMINI_15;
        }
    }

}
