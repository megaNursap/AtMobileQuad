package utils.api.mailinator;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import utils.api.APIHelper;
import utils.factory.DriverUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@Setter
@Getter
@Builder
@ToString
public class MailinatorAPI {

    public String getOTP(String email) {
        APIHelper.builder.setBaseUri(APIHelper.mailinatorURI);
        RequestSpecification requestSpec = APIHelper.builder.build();

        Map<String, String> headerList = new HashMap<>();
        headerList.put("Authorization", "Bearer e839428c5e5848c38855a405cbfda23e");
        headerList.put("Cookie", "JSESSIONID=node0xnqtbgsb5kz91vuwic2obfhtt78171.node0; SERVERID=s1");

        ValidatableResponse response1 = given().spec(requestSpec)
                .headers(headerList)
                .when()
                .get(APIHelper.mailinatorURI + "/api/v2/domains/public/inboxes/" + email)
                .then()
                .statusCode(200);

        int latestInboxIndex = response1.extract().jsonPath().getList("msgs").size() - 1;

        System.out.println("Mail Id: " + response1.extract().jsonPath().getString("msgs[" + latestInboxIndex + "].id"));

        ValidatableResponse response2 = given().spec(requestSpec)
                .headers(headerList)
                .when()
                .get(APIHelper.mailinatorURI + "/api/v2/domains/public/inboxes/" + email + "/messages/" + response1.extract().jsonPath().getString("msgs[" + latestInboxIndex + "].id"))
                .then()
                .statusCode(200);

        System.out.println("OTP is: " + DriverUtils.extractDigitFromStrings(response2.extract().jsonPath().getString("parts[0].body")));
        return DriverUtils.extractDigitFromStrings(response2.extract().jsonPath().getString("parts[0].body"));
    }
}
