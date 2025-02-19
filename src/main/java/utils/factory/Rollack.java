package utils.factory;

import org.testng.annotations.Test;

public class Rollack {

    @Test
    public static void deletePOI() {
        DynamoDeleteCampPOI.deletePOI("1c901ee7-4b87-4940-a542-341cdf547e39");
    }
}
