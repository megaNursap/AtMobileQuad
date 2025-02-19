package utils;

import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Config {

    public final static Logger LOGGER = LogManager.getLogger("General");

    public static Environments ENV = ConfigFactory.create(Environments.class, System.getenv());

    public static String countryLocation() {
        String location = "";
        switch (Config.ENV.COUNTRY()) {
            case "PH" :
                location = Config.ENV.LONGITUDE_PH() + ", " + Config.ENV.LATITUDE_PH();
                break;
            case "SG" :
                location = Config.ENV.LONGITUDE_SG() + ", " + Config.ENV.LATITUDE_SG();
                break;
            case "MY" :
                location = Config.ENV.LONGITUDE_MY() + ", " + Config.ENV.LATITUDE_MY();
                break;
            case "US" :
                location = Config.ENV.LONGITUDE_US() + ", " + Config.ENV.LATITUDE_US();
                break;
            case "PL" :
                location = Config.ENV.LONGITUDE_PL() + ", " + Config.ENV.LATITUDE_PL();
                break;
            case "NG" :
                location = Config.ENV.LONGITUDE_NG() + ", " + Config.ENV.LATITUDE_NG();
                break;
            case "BR" :
                location = Config.ENV.LONGITUDE_BR() + ", " + Config.ENV.LATITUDE_BR();
                break;
            case "KZ" :
                location = Config.ENV.LONGITUDE_KZ() + ", " + Config.ENV.LATITUDE_KZ();
                break;
            case "MX" :
                location = Config.ENV.LONGITUDE_MX() + ", " + Config.ENV.LATITUDE_MX();
                break;
            default :
                location = Config.ENV.LONGITUDE_ID() + ", " + Config.ENV.LATITUDE_ID();

        }
        return location;
    }

    public static String countryRegion() {
        String region = "";
        switch (Config.ENV.COUNTRY()) {
            case "PH" :
                region = Config.ENV.REGION_ID();
                break;
            case "SG" :
                region = Config.ENV.REGION_SG();
                break;
            case "MY" :
                region = Config.ENV.REGION_ID();
                break;
            case "US" :
                region = Config.ENV.REGION_ID();
                break;
            case "PL" :
                region = Config.ENV.REGION_ID();
                break;
            case "NG" :
                region = Config.ENV.REGION_ID();
                break;
            case "BR" :
                region = Config.ENV.REGION_ID();
                break;
            case "KZ" :
                region = Config.ENV.REGION_ID();
                break;
            case "MX" :
                region = Config.ENV.REGION_ID();
                break;
            default :
                region = Config.ENV.REGION_ID();
        }
        return region;
    }

    public static String BS_USERNAME = System.getenv("BROWSERSTACK_USERNAME");
    public static String BS_ACCESS_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");

    public static String BS_APP_URL = System.getenv("BROWSERSTACK_APP_URL");
    public static String BS_BUILD_NAME = System.getenv("BROWSERSTACK_BUILD_NAME");

//    public static String BS_USERNAME = "jackla_uaJApN";
//    public static String BS_ACCESS_KEY = "pkRT5QPEqVst1aZ1kpSR";
//    public static String BS_APP_URL = "bs://b3b9b854d953aa01b4baa1e47bda8ed29b233a36";
//    public static String BS_BUILD_NAME = "Android Test";
//
//    public static String BS_USERNAME = "jackla_uaJApN";
//    public static String BS_ACCESS_KEY = "pkRT5QPEqVst1aZ1kpSR";
////    public static String BS_APP_URL = "bs://9b3baa24bfe763e93621c48b0dd657382e192a4e";
//    public static String BS_APP_URL = "bs://53792018872fd5dbe568c08e2c2cc4784de905ae";
//
//    public static String BS_BUILD_NAME = "iOS Test";

}
