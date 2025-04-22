package apoc.ml;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class OpenAIGroqAPIsIT {



    public static class OpenAIGroqAPIsITllama2 extends OpenAiGroqAPIsBaseIT{

        public static final String MODEL = "llama2-70b-4096";

        @Override
        String getDefModel() {
            return MODEL;
        }
    }

    public static class OpenAIGroqAPIsITmixtral extends OpenAiGroqAPIsBaseIT{

        public static final String MODEL = "mixtral-8x7b-32768";

        @Override
        String getDefModel() {
            return MODEL;
        }
    }

    public static class OpenAIGroqAPIsITllama3 extends OpenAiGroqAPIsBaseIT{

        public static final String MODEL = "llama-3.3-70b-versatile";

        @Override
        String getDefModel() {
            return MODEL;
        }
    }

}
