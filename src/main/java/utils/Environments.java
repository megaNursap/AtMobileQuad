package utils;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;

@LoadPolicy(LoadType.FIRST)
@Sources({"classpath:env.${env}.properties"
})
public interface Environments extends Config {

    @Key("DESKTOP_WEB.URL")
    String WEB_URL();

    @Key("location")
    @DefaultValue("lc")
    String RUN_LOCATION();

    @Key("platform")
    String PLATFORM();

    @Key("country")
    String COUNTRY();

    @Key("page.time_out")
    @DefaultValue("30")
    long TIME_OUTS();

    @Key("GEOLANCER.USERNAME")
    String GEOLANCER_USERNAME();

    @Key("GEOLANCER.PASSWORD")
    String GEOLANCER_PASSWORD();

    @Key("GEO.USERNAME")
    String GEO_USERNAME();

    @Key("GEO.PASSWORD")
    String GEO_PASSWORD();

    @Key("LATITUDE")
    String LATITUDE();

    @Key("LONGITUDE")
    String LONGITUDE();

    @Key("API.VERSION")
    String API_VERSION();

    @Key("PLACE.NAME")
    String PLACE_NAME();

    @Key("CAMPAIGN.NAME")
    String CAMPAIGN_NAME();

    @Key("BUSINESS.NAME")
    String BUSINESS_NAME();

    @Key("STREET.NAME")
    String STREET_NAME();

    @Key("HOUSE.BUILDINGNUMER")
    String HOUSE_BUILDING_NUMBER();

    @Key("FLOOR.UNITNUMBER")
    String FLOOR_UNIT_NUMBER();

    @Key("COLLECTOR.ANDROID.MAILINATOR")
    String COLLECTOR_ANDROID_MAILINATOR();

    @Key("VERIFIER.ANDROID.MAILINATOR")
    String VERIFIER_ANDROID_MAILINATOR();

    @Key("LATITUDE.ID")
    String LATITUDE_ID();

    @Key("LONGITUDE.ID")
    String LONGITUDE_ID();

    @Key("LATITUDE.PH")
    String LATITUDE_PH();

    @Key("LONGITUDE.PH")
    String LONGITUDE_PH();

    @Key("LATITUDE.SG")
    String LATITUDE_SG();

    @Key("LONGITUDE.SG")
    String LONGITUDE_SG();

    @Key("LATITUDE.MY")
    String LATITUDE_MY();

    @Key("LONGITUDE.MY")
    String LONGITUDE_MY();

    @Key("LATITUDE.US")
    String LATITUDE_US();

    @Key("LONGITUDE.US")
    String LONGITUDE_US();

    @Key("LATITUDE.PL")
    String LATITUDE_PL();

    @Key("LONGITUDE.PL")
    String LONGITUDE_PL();

    @Key("LATITUDE.NG")
    String LATITUDE_NG();

    @Key("LONGITUDE.NG")
    String LONGITUDE_NG();

    @Key("LATITUDE.BR")
    String LATITUDE_BR();

    @Key("LONGITUDE.BR")
    String LONGITUDE_BR();

    @Key("LATITUDE.MX")
    String LATITUDE_MX();

    @Key("LONGITUDE.MX")
    String LONGITUDE_MX();

    @Key("LATITUDE.KZ")
    String LATITUDE_KZ();

    @Key("LONGITUDE.KZ")
    String LONGITUDE_KZ();

    @Key("FIRST.NAME.SIGNUP")
    String FIRST_NAME_SIGNUP();

    @Key("LAST.NAME.SIGNUP")
    String LAST_NAME_SIGNUP();

    @Key("REFERRAL.CODE.SIGNUP")
    String REFERRAL_CODE_SIGNUP();

    @Key("REGION.ID")
    String REGION_ID();

    @Key("CITY.ID")
    String CITY_ID();

    @Key("REGION.PH")
    String REGION_PH();

    @Key("CITY.PH")
    String CITY_PH();

    @Key("REGION.SG")
    String REGION_SG();

    @Key("CITY.SG")
    String CITY_SG();

    @Key("REGION.MY")
    String REGION_MY();

    @Key("CITY.MY")
    String CITY_MY();

    @Key("REGION.US")
    String REGION_US();

    @Key("CITY.US")
    String CITY_US();

    @Key("REGION.PL")
    String REGION_PL();

    @Key("CITY.PL")
    String CITY_PL();

    @Key("REGION.NG")
    String REGION_NG();

    @Key("CITY.NG")
    String CITY_NG();

    @Key("REGION.BR")
    String REGION_BR();

    @Key("CITY.BR")
    String CITY_BR();

    @Key("REGION.MX")
    String REGION_MX();

    @Key("CITY.MX")
    String CITY_MX();

    @Key("REGION.KZ")
    String REGION_KZ();

    @Key("CITY.KZ")
    String CITY_KZ();

    @Key("FORGOT.PASSWORD.USER")
    String FORGOT_PASSWORD_USER();

    @Key("TWILIO.PHONE.NUMBER")
    String TWILIO_PHONE_NUMBER();





}
