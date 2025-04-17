package apoc.ml;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class OpenAiIT {

    public static class OpenAIITVersion4 extends OpenAiBaseIT{

        public static final String GPT_41_MODEL = "gpt-4.1";

        @Override
        String getDefModel() {
            return GPT_41_MODEL;
        }
    }

    public static class OpenAIITVersion4turbo extends OpenAiBaseIT{

        public static final String GPT_41_MODEL = "gpt-4-turbo";

        @Override
        String getDefModel() {
            return GPT_41_MODEL;
        }
    }

    public static class OpenAIITVersion3 extends OpenAiBaseIT{

        public static final String GPT_35_MODEL = "gpt-3.5-turbo";

        @Override
        String getDefModel() {
            return GPT_35_MODEL;
        }
    }

}
