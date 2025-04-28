package apoc.ml;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class OpenAIGroqAPIsIT {

    public static class OpenAIGroqDfaultIT extends OpenAiGroqAPIsBaseIT{
        @Override
        String getDefModel() {
            return null;
        }
    }

    public static class OpenAIGroqAPIsLlama2IT extends OpenAiGroqAPIsBaseIT{

        public static final String MODEL = "llama2-70b-4096";

        @Override
        String getDefModel() {
            return MODEL;
        }
    }

    public static class OpenAIGroqAPIsMixtralIT extends OpenAiGroqAPIsBaseIT{

        public static final String MODEL = "mixtral-8x7b-32768";

        @Override
        String getDefModel() {
            return MODEL;
        }
    }

    public static class OpenAIGroqAPIsLlama3IT extends OpenAiGroqAPIsBaseIT{

        public static final String MODEL = "llama-3.3-70b-versatile";

        @Override
        String getDefModel() {
            return MODEL;
        }
    }

}
