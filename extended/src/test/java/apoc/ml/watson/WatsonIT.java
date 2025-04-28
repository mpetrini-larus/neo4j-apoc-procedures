package apoc.ml.watson;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class WatsonIT {

    public static class WatsonDefaultIT extends WatsonBaseIT {
        @Override
        String getDefModel() {
            return null;
        }
    }


    public static class WatsonSlateV1IT extends WatsonBaseIT {

        public static final String MODEL = "ibm/slate-125m-english-rtrvr";

        @Override
        String getDefModel() {
            return MODEL;
        }

    }

    public static class WatsonSlateV2IT extends WatsonBaseIT {

        public static final String MODEL = "slate-125m-english-rtrvr-v2";

        @Override
        String getDefModel() {
            return MODEL;
        }

    }

}
