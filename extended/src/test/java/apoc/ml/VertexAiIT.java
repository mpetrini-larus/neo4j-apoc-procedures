package apoc.ml;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class VertexAiIT {

    public static class VertexAIDefaultIT extends VertexAiBaseIT{
        @Override
        String getDefModel() {
            return null;
        }
    }

    public static class VertexAIVersion15IT extends VertexAiBaseIT{

        public static final String GEMINI_15 = "gemini-1.5-flash-001";

        @Override
        String getDefModel() {
            return GEMINI_15;
        }
    }

    public static class VertexAIVersion25IT extends VertexAiBaseIT{

        public static final String GEMINI_25 = "gemini-2.5-pro-exp-03-25";

        @Override
        String getDefModel() {
            return GEMINI_25;
        }
    }

}
