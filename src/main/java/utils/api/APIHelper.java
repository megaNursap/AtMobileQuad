package utils.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class APIHelper {

    public static String baseURI = "https://stag.datastreamx.io";

    public static String baseAdminPanelURI = "https://staging-starwars-behindthescenes-apis.geolancer.app";

    public static String mailinatorURI = "https://mailinator.com";

    public static RequestSpecBuilder builder = new RequestSpecBuilder();
    public static RequestSpecification requestSpec;
}
