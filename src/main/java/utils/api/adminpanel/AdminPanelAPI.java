package utils.api.adminpanel;

import com.google.gson.JsonArray;
import org.json.simple.JSONObject;
import utils.Config;
import utils.ScenarioContext;
import utils.api.APIHelper;
import com.google.gson.JsonObject;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import utils.factory.DynamoDeleteCampPOI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@Setter
@Getter
@Builder
@ToString
public class AdminPanelAPI {

    public void loginV2() {
        APIHelper.builder.setBaseUri(APIHelper.baseURI);
        RequestSpecification requestSpec = APIHelper.builder.build();
        Map<String, String> headerList = new HashMap<>();
        headerList.put("Content-Type", "application/json");
        headerList.put("app-version-code", "v2060100");

        JsonObject jObject = new JsonObject();
        jObject.addProperty("email", "lquoc+1@quadrant.io");
        jObject.addProperty("password", "MynameisJack91@");

        ValidatableResponse response = given().spec(requestSpec)
                .headers(headerList)
                .body(jObject.toString())
                .when()
                .post(APIHelper.baseURI + "/v2060100/api/login/v2")
                .then()
                .statusCode(200);

        System.out.println("Access Token: " + response.extract().jsonPath().getString("data.access_token"));

        ScenarioContext.currentContext().set("Access Token").with(response.extract().jsonPath().getString("data.access_token"));
    }

    public void getPOIId(String poiName) {
        APIHelper.builder.setBaseUri(APIHelper.baseURI);
        RequestSpecification requestSpec = APIHelper.builder.build();
        Map<String, String> headerList = new HashMap<>();
        headerList.put("accept", "application/json");
        headerList.put("Content-Type", "application/json");
        headerList.put("app-version-code", "2010002");
        headerList.put("Authorization", "Bearer " + ScenarioContext.currentContext().get("Access Token", String.class));

        System.out.println(Config.ENV.API_VERSION());
//        System.out.println(Config.ENV.LATITUDE());
//        System.out.println(Config.ENV.LONGITUDE());

        System.out.println("Country: " + Config.ENV.COUNTRY());

        JsonArray list = new JsonArray();
        switch (Config.ENV.COUNTRY()){
            case "PH":
                System.out.println("lat PH = "+Config.ENV.LATITUDE_PH());
                System.out.println("long PH = "+Config.ENV.LONGITUDE_PH());
                list.add(Double.parseDouble(Config.ENV.LATITUDE_PH()));
                list.add(Double.parseDouble(Config.ENV.LONGITUDE_PH()));
                break;
            case "SG":
                System.out.println("lat SG = "+Config.ENV.LATITUDE_SG());
                System.out.println("long SG = "+Config.ENV.LONGITUDE_SG());
                list.add(Double.parseDouble(Config.ENV.LATITUDE_SG()));
                list.add(Double.parseDouble(Config.ENV.LONGITUDE_SG()));
                break;
            case "US":
                System.out.println("lat US = "+Config.ENV.LATITUDE_US());
                System.out.println("long US = "+Config.ENV.LONGITUDE_US());
                list.add(Double.parseDouble(Config.ENV.LATITUDE_US()));
                list.add(Double.parseDouble(Config.ENV.LONGITUDE_US()));
                break;
            case "PL":
                System.out.println("lat PL = "+Config.ENV.LATITUDE_PL());
                System.out.println("long PL = "+Config.ENV.LONGITUDE_PL());
                list.add(Double.parseDouble(Config.ENV.LATITUDE_PL()));
                list.add(Double.parseDouble(Config.ENV.LONGITUDE_PL()));
                break;
            case "NG":
                System.out.println("lat NG = "+Config.ENV.LATITUDE_NG());
                System.out.println("long NG = "+Config.ENV.LONGITUDE_NG());
                list.add(Double.parseDouble(Config.ENV.LATITUDE_NG()));
                list.add(Double.parseDouble(Config.ENV.LONGITUDE_NG()));
                break;
            case "BR":
                System.out.println("lat BR = "+Config.ENV.LATITUDE_BR());
                System.out.println("long BR = "+Config.ENV.LONGITUDE_BR());
                list.add(Double.parseDouble(Config.ENV.LATITUDE_BR()));
                list.add(Double.parseDouble(Config.ENV.LONGITUDE_BR()));
                break;
            case "KZ":
                System.out.println("lat KZ = "+Config.ENV.LATITUDE_KZ());
                System.out.println("long KZ = "+Config.ENV.LONGITUDE_KZ());
                list.add(Double.parseDouble(Config.ENV.LATITUDE_KZ()));
                list.add(Double.parseDouble(Config.ENV.LONGITUDE_KZ()));
                break;
            case "MX":
                System.out.println("lat MX = "+Config.ENV.LATITUDE_MX());
                System.out.println("long MX = "+Config.ENV.LONGITUDE_MX());
                list.add(Double.parseDouble(Config.ENV.LATITUDE_MX()));
                list.add(Double.parseDouble(Config.ENV.LONGITUDE_MX()));
                break;
            default :
                // default on ID
                System.out.println("lat ID = "+Config.ENV.LATITUDE_ID());
                System.out.println("long ID = "+Config.ENV.LONGITUDE_ID());
                list.add(Double.parseDouble(Config.ENV.LATITUDE_ID()));
                list.add(Double.parseDouble(Config.ENV.LONGITUDE_ID()));
        }

        JsonObject jObject = new JsonObject();
        jObject.add("location", list);

        ValidatableResponse response = given().spec(requestSpec)
                .headers(headerList)
                .body(jObject.toString())
                .when()
                .post(APIHelper.baseURI + "/v2010002/api/poi/range?user_id=ca36692a-d642-433e-af74-350a96fe2b3b&country_code=" + Config.ENV.COUNTRY())
                .then()
                .statusCode(200);

        int item_size = Integer.parseInt(response.extract().jsonPath().getString("data.Items.size()"));
        System.out.println("size " + item_size);

        int index = 0;

        for (int i=1; i < item_size; i++) {
            String location_name = response.extract().jsonPath().getString("data.Items[" + i + "].location_name");
//            System.out.println("location_name = "+location_name);
//            System.out.println("poiName = "+poiName);
            if (location_name.equalsIgnoreCase(poiName)) {
                index = i;
                break;
            }
        }
        System.out.println("index " + index);

        ScenarioContext.currentContext().set("POI ID").with(response.extract().jsonPath().getString("data.Items[" + index + "].id"));
        ScenarioContext.currentContext().set("Campaign ID").with(response.extract().jsonPath().getString("data.Items[" + index + "].id"));
        System.out.println("POI ID " + ScenarioContext.currentContext().get("POI ID", String.class));
    }

    public void deleteAllPOIs() {
        APIHelper.builder.setBaseUri(APIHelper.baseURI);
        RequestSpecification requestSpec = APIHelper.builder.build();
        Map<String, String> headerList = new HashMap<>();
        headerList.put("accept", "application/json");
        headerList.put("Content-Type", "application/json");
        headerList.put("app-version-code", Config.ENV.API_VERSION());
        headerList.put("Authorization", "Bearer " + ScenarioContext.currentContext().get("Access Token", String.class));

        JsonArray list = new JsonArray();
        list.add(Double.parseDouble(Config.ENV.LATITUDE()));
        list.add(Double.parseDouble(Config.ENV.LONGITUDE()));


        JsonObject jObject = new JsonObject();
        jObject.add("location", list);

        ValidatableResponse response = given().spec(requestSpec)
                .headers(headerList)
                .body(jObject.toString())
                .when()
                .post(APIHelper.baseURI + "/v"  + Config.ENV.API_VERSION() + "/api/poi/range?user_id=ca36692a-d642-433e-af74-350a96fe2b3b&country_code=ID")
                .then()
                .statusCode(200);

        int item_size = Integer.parseInt(response.extract().jsonPath().getString("data.Items.size()"));
        System.out.println("size " + item_size);


        for (int i=1; i < item_size; i++) {
            String poi_id = response.extract().jsonPath().getString("data.Items[" + i + "].id");
            DynamoDeleteCampPOI.deletePOI(poi_id);
        }
    }

    public void setStatusForPOIFromAdminPanel(String status) throws Exception {
        APIHelper.builder.setBaseUri(APIHelper.baseAdminPanelURI);
        RequestSpecification requestSpec = APIHelper.builder.build();
        Map<String, String> headerList = new HashMap<>();
        headerList.put("Accept", "application/json");
        headerList.put("Content-Type", "application/json");
        headerList.put("x-api-key", "NNZUygSTzJ6MSO8IOoVxf86Nxdx54Cgj11BLHP64");

        String messageStatus = "null";
        JsonObject jObject = new JsonObject();
        JSONObject editableObj = new JSONObject();

        jObject.addProperty("poi_id", ScenarioContext.currentContext().get("POI ID", String.class));
        jObject.addProperty("status", status);
        jObject.addProperty("campaignModeStatus", false);
        jObject.addProperty("isRegularPoi", true);

        ValidatableResponse response = given().spec(requestSpec)
                .headers(headerList)
                .body(jObject.toString())
                .when()
                .post(APIHelper.baseAdminPanelURI + "/api/poi_apprvl_ext?entity=qa_automation")
                .then()
                .statusCode(200);
        System.out.println("##############################");
        System.out.println("Success, POI status is " + messageStatus);
        System.out.println("##############################");
    }

    public void setStatusForCampaignPOIFromAdminPanel(String status) throws Exception {
        APIHelper.builder.setBaseUri(APIHelper.baseAdminPanelURI);
        RequestSpecification requestSpec = APIHelper.builder.build();
        Map<String, String> headerList = new HashMap<>();
        headerList.put("Accept", "application/json");
        headerList.put("Content-Type", "application/json");
        headerList.put("x-api-key", "NNZUygSTzJ6MSO8IOoVxf86Nxdx54Cgj11BLHP64");

        JsonObject jObject = new JsonObject();
        JsonObject editableObj = new JsonObject();
        editableObj.addProperty("admin_action_email", "lquoc@quadrant.io");

        jObject.addProperty("poi_id", ScenarioContext.currentContext().get("POI ID", String.class));
        jObject.addProperty("status", status);
        jObject.add("editableObj", editableObj);
        jObject.addProperty("campaignModeStatus", true);
        jObject.addProperty("isRegularPoi", false);

        ValidatableResponse response = given().spec(requestSpec)
                .headers(headerList)
                .body(jObject.toString())
                .when()
                .post(APIHelper.baseAdminPanelURI + "/api/poi_apprvl_ext?entity=qa_automation")
                .then()
                .statusCode(200);
    }

    public void createSamplePOIForCampaign() {
        APIHelper.builder.setBaseUri(APIHelper.baseURI);
        RequestSpecification requestSpec = APIHelper.builder.build();
        Map<String, String> headerList = new HashMap<>();
        headerList.put("accept", "application/json");
        headerList.put("Content-Type", "application/json");
        headerList.put("app-version-code", "v2060100");
        headerList.put("Authorization", "Bearer " + ScenarioContext.currentContext().get("Access Token", String.class));

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
        String formattedDate = myDateObj.format(myFormatObj);

        String campaignPOIName = "Campaign-POI-auto-test-" + formattedDate;
        ScenarioContext.currentContext().set("Campaign POI Name").with(campaignPOIName);

        JsonObject jObject = new JsonObject();
        JsonArray store_front_photo_list = new JsonArray();
        store_front_photo_list.add("temp_ce11c3af-588b-42de-bdc0-495ae7c0d66d_20230428_2235012854253940219119148.jpg");
        JsonArray has_in_store_shopping_photo_list = new JsonArray();
        has_in_store_shopping_photo_list.add("temp_ce11c3af-588b-42de-bdc0-495ae7c0d66d_20230428_2235533996605304731027737.jpg");
        JsonArray business_status_photo_list = new JsonArray();
        business_status_photo_list.add("temp_ce11c3af-588b-42de-bdc0-495ae7c0d66d_20230428_2234325543124715154171489.jpg");
        JsonArray location_name_photo_list = new JsonArray();
        location_name_photo_list.add("temp_ce11c3af-588b-42de-bdc0-495ae7c0d66d_20230428_223447636998023462482442.jpg");
        JsonArray has_delivery_photo_list = new JsonArray();
        has_delivery_photo_list.add("temp_ce11c3af-588b-42de-bdc0-495ae7c0d66d_20230428_2236056191111129930732207.jpg");
        JsonObject deviceIdjObject = new JsonObject();
        deviceIdjObject.addProperty("idfa","502e2c8a-f20c-433a-8611-7e54a41b4fd3");
        deviceIdjObject.addProperty("distinct_id","ffffffff-d9c9-d893-d9c9-d89300000000");
        deviceIdjObject.addProperty("idfa_type","afid");
        JsonArray location = new JsonArray();

        switch (Config.ENV.COUNTRY()){
            case "PH":
                System.out.println("lat PH = "+Config.ENV.LATITUDE_PH());
                System.out.println("long PH = "+Config.ENV.LONGITUDE_PH());
                location.add(Double.parseDouble(Config.ENV.LATITUDE_PH()));
                location.add(Double.parseDouble(Config.ENV.LONGITUDE_PH()));
            case "SG":
                System.out.println("lat SG = "+Config.ENV.LATITUDE_SG());
                System.out.println("long SG = "+Config.ENV.LONGITUDE_SG());
                location.add(Double.parseDouble(Config.ENV.LATITUDE_SG()));
                location.add(Double.parseDouble(Config.ENV.LONGITUDE_SG()));
            case "US":
                System.out.println("lat US = "+Config.ENV.LATITUDE_US());
                System.out.println("long US = "+Config.ENV.LONGITUDE_US());
                location.add(Double.parseDouble(Config.ENV.LATITUDE_US()));
                location.add(Double.parseDouble(Config.ENV.LONGITUDE_US()));
            case "PL":
                System.out.println("lat PL = "+Config.ENV.LATITUDE_PL());
                System.out.println("long PL = "+Config.ENV.LONGITUDE_PL());
                location.add(Double.parseDouble(Config.ENV.LATITUDE_PL()));
                location.add(Double.parseDouble(Config.ENV.LONGITUDE_PL()));
            case "NG":
                System.out.println("lat NG = "+Config.ENV.LATITUDE_NG());
                System.out.println("long NG = "+Config.ENV.LONGITUDE_NG());
                location.add(Double.parseDouble(Config.ENV.LATITUDE_NG()));
                location.add(Double.parseDouble(Config.ENV.LONGITUDE_NG()));
            case "BR":
                System.out.println("lat BR = "+Config.ENV.LATITUDE_BR());
                System.out.println("long BR = "+Config.ENV.LONGITUDE_BR());
                location.add(Double.parseDouble(Config.ENV.LATITUDE_BR()));
                location.add(Double.parseDouble(Config.ENV.LONGITUDE_BR()));
            case "KZ":
                System.out.println("lat KZ = "+Config.ENV.LATITUDE_KZ());
                System.out.println("long KZ = "+Config.ENV.LONGITUDE_KZ());
                location.add(Double.parseDouble(Config.ENV.LATITUDE_KZ()));
                location.add(Double.parseDouble(Config.ENV.LONGITUDE_KZ()));
            case "MX":
                System.out.println("lat MX = "+Config.ENV.LATITUDE_MX());
                System.out.println("long MX = "+Config.ENV.LONGITUDE_MX());
                location.add(Double.parseDouble(Config.ENV.LATITUDE_MX()));
                location.add(Double.parseDouble(Config.ENV.LONGITUDE_MX()));
            default :
                // default on ID
                System.out.println("lat ID = "+Config.ENV.LATITUDE_ID());
                System.out.println("long ID = "+Config.ENV.LONGITUDE_ID());
                location.add(Double.parseDouble(Config.ENV.LATITUDE_ID()));
                location.add(Double.parseDouble(Config.ENV.LONGITUDE_ID()));
        }
        JsonArray opening_hour_list = new JsonArray();
        JsonObject mon_opening_hour_object = new JsonObject();
        mon_opening_hour_object.addProperty("closed", "05:00Pm");
        mon_opening_hour_object.addProperty("day", "Mon");
        mon_opening_hour_object.addProperty("open", "08:00Am");

        JsonObject tue_opening_hour_object = new JsonObject();
        tue_opening_hour_object.addProperty("closed", "05:00Pm");
        tue_opening_hour_object.addProperty("day", "Tue");
        tue_opening_hour_object.addProperty("open", "08:00Am");

        JsonObject wed_opening_hour_object = new JsonObject();
        wed_opening_hour_object.addProperty("closed", "05:00Pm");
        wed_opening_hour_object.addProperty("day", "Wed");
        wed_opening_hour_object.addProperty("open", "08:00Am");

        JsonObject thur_opening_hour_object = new JsonObject();
        thur_opening_hour_object.addProperty("closed", "05:00Pm");
        thur_opening_hour_object.addProperty("day", "Thur");
        thur_opening_hour_object.addProperty("open", "08:00Am");

        JsonObject fri_opening_hour_object = new JsonObject();
        fri_opening_hour_object.addProperty("closed", "05:00Pm");
        fri_opening_hour_object.addProperty("day", "Fri");
        fri_opening_hour_object.addProperty("open", "08:00Am");

        JsonObject sat_opening_hour_object = new JsonObject();
        sat_opening_hour_object.addProperty("closed", "05:00Pm");
        sat_opening_hour_object.addProperty("day", "Sat");
        sat_opening_hour_object.addProperty("open", "08:00Am");

        JsonObject sun_opening_hour_object = new JsonObject();
        sat_opening_hour_object.addProperty("closed", "05:00Pm");
        sat_opening_hour_object.addProperty("day", "Sun");
        sat_opening_hour_object.addProperty("open", "08:00Am");

        opening_hour_list.add(mon_opening_hour_object);
        opening_hour_list.add(tue_opening_hour_object);
        opening_hour_list.add(wed_opening_hour_object);
        opening_hour_list.add(thur_opening_hour_object);
        opening_hour_list.add(fri_opening_hour_object);
        opening_hour_list.add(sat_opening_hour_object);
        opening_hour_list.add(sun_opening_hour_object);


        jObject.addProperty("has_dine_in", "Not Applicable");
        jObject.addProperty("business_hours_status", "No, they are not on display");
        jObject.add("store_front_photo", store_front_photo_list);
        jObject.add("has_in_store_shopping_photo", has_in_store_shopping_photo_list);
        jObject.addProperty("campaignMode", "533958be-ec35-44db-ac52-7c54120f9695");
        jObject.add("business_status_photo", business_status_photo_list);
        jObject.addProperty("has_take_out", "Not Applicable");
        jObject.addProperty("upload_file_status", true);
        jObject.addProperty("id", "19c549f2-1e7a-49fb-b13d-d7550f13bcb8");
        jObject.add("location_name_photo", location_name_photo_list);
        jObject.addProperty("website", "www");
        jObject.addProperty("address", "Jalan Muhamad Kafi 1 Blok Nila No.2, RT.2/RW.1, Ciganjur, Kecamatan Jagakarsa, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12630, Indonesia");
        jObject.addProperty("business_status", "Business is nearby (30 meter or closer) and open but not exactly at the location pinned on the map");
        jObject.add("device_id", deviceIdjObject);
        jObject.addProperty("has_in_store_shopping", "Yes");
        jObject.addProperty("action_user_email", "lquoc+1@quadrant.io");
        jObject.add("userLocation", location);
        jObject.addProperty("campaign_category", "Food and beverage business");
        jObject.addProperty("has_curbside_pickup", "No");
        jObject.addProperty("country_code", "ID");
        jObject.addProperty("location_name", campaignPOIName);
        jObject.addProperty("has_delivery", "Yes");
        jObject.addProperty("user_id", "ca36692a-d642-433e-af74-350a96fe2b3b");
        jObject.add("opening_hours", opening_hour_list);
        jObject.add("location", location);
        jObject.addProperty("phone_number", "N/A");
        jObject.add("has_delivery_photo", has_delivery_photo_list);
        jObject.add("on_submit_location", location);

        ValidatableResponse response = given().spec(requestSpec)
                .headers(headerList)
                .body(jObject.toString())
                .when()
                .post(APIHelper.baseURI + "/v2060100/api/poi")
                .then()
                .statusCode(200);

        System.out.println(response.extract().jsonPath().getString("message"));
    }
}
