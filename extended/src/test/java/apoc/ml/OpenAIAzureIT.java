package apoc.ml;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class OpenAIAzureIT {

    public static class OpenAIAzureIT35 extends OpenAiAzureBaseIT{

        public static final String GPT_35_MODEL = "gpt-35-turbo";

        @Override
        String getDefModel() {
            return GPT_35_MODEL;
        }
    }

    public static class OpenAIAzureIT41 extends OpenAiAzureBaseIT{

        public static final String GPT_35_MODEL = "gpt-4.1";

        @Override
        String getDefModel() {
            return GPT_35_MODEL;
        }
    }

    public static class OpenAIAzureIT4o extends OpenAiAzureBaseIT{

        public static final String GPT_35_MODEL = "gpt-4o";

        @Override
        String getDefModel() {
            return GPT_35_MODEL;
        }
    }

}
