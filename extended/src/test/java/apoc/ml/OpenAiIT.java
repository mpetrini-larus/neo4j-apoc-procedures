package apoc.ml;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class OpenAiIT {

    public static class OpenAIDefaultIT extends OpenAiBaseIT{
        @Override
        String getDefModel() {
            return null;
        }
    }

    public static class OpenAIVersion4IT extends OpenAiBaseIT{

        public static final String GPT_41_MODEL = "gpt-4.1";

        @Override
        String getDefModel() {
            return GPT_41_MODEL;
        }
    }

    public static class OpenAIVersion4turboIT extends OpenAiBaseIT{

        public static final String GPT_41_MODEL = "gpt-4-turbo";

        @Override
        String getDefModel() {
            return GPT_41_MODEL;
        }
    }

    public static class OpenAIVersion3IT extends OpenAiBaseIT{

        public static final String GPT_35_MODEL = "gpt-3.5-turbo";

        @Override
        String getDefModel() {
            return GPT_35_MODEL;
        }
    }

}
