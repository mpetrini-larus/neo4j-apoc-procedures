package apoc.ml;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class OpenAIMistralApiIT {

    public static class OpenAIDefaultIT extends OpenAIMistralApiBaseIT{
        @Override
        String getDefModel() {
            return null;
        }
    }

    public static class OpenAIMistralSmallIT extends OpenAIMistralApiBaseIT{

        public static final String MISTRAL = "mistral-embed";

        @Override
        String getDefModel() {
            return MISTRAL;
        }

    }

}
