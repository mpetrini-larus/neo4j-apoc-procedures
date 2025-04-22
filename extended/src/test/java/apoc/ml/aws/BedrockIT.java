package apoc.ml.aws;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class BedrockIT {

    public static class BedrockITTVersionTitanV1 extends BedrockBaseIT {

        public static final String TITAN_V1 = "amazon.titan-embed-text-v1";

        @Override
        String getDefModel() {
            return TITAN_V1;
        }
    }

    public static class BedrockITTVersionTitanV2 extends BedrockBaseIT {

        public static final String TITAN_V2 = "amazon.titan-embed-text-v2:0";

        @Override
        String getDefModel() {
            return TITAN_V2;
        }
    }

    public static class BedrockITTVersionNovaV1 extends BedrockBaseIT {

        public static final String NOVA_V1 = "us.amazon.nova-pro-v1:0";

        @Override
        String getDefModel() {
            return NOVA_V1;
        }
    }

}
