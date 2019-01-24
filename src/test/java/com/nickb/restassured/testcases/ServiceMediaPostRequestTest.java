package com.nickb.restassured.testcases;

import com.nickb.restassured.base.BaseTest;
import com.nickb.restassured.utils.TestUtils;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.containsString;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ServiceMediaPostRequestTest extends BaseTest{
    
    @Test
    public void checkServiceMediaPostRequestTest() {

        RestAssured.baseURI = envConfig.getProperty("m_dev_http");

        Map<String, String> requestHeaders = new HashMap<String, String>() {
            {
                put("Content-Type", "application/json");
                put("Accept", "application/seamless.app.resource-1.2+json");
            }
        };

        try {
            given()
                    .headers(requestHeaders)
                    .body(TestUtils.convertJsonFromFileToString("src/test/resources/testdata/test.json"))
            .when()
                    .post(envConfig.getProperty("m_endpoint-path"))
            .then()
            .assertThat()
                    .statusCode(200).and()
                    .header("Content-Type", "application/seamless.app.resource-1.2+json").and()
                    .body(containsString("adDatas"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
