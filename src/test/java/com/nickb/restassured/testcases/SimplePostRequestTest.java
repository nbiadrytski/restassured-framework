package com.nickb.restassured.testcases;

import com.nickb.restassured.base.BaseTest;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.containsString;

import java.util.HashMap;
import java.util.Map;

public class SimplePostRequestTest extends BaseTest{
    
    @Test
    public void simplePostRequestTest() {

        RestAssured.baseURI = envConfig.getProperty("m_dev_http");
        
        String postBody = "{\"id\":2134,\"topAdId\":\"2134\",\"creativeId\":\"2134\"," +
                "\"uuid\":\"wPQteS1WZbiuaGIH4GK0gOA1wpXSEjnp\"," +
                "\"url\":\"https://s3.amazonaws.com/mtvnet-seamless/qa-artifacts/seamless_docs/seamless_media_sources/patch_ad_uat2.mp4\"," +
                "\"bitrate\":748,\"width\":1280,\"height\":720}";

        Map<String, String> requestHeaders = new HashMap<String, String>() {
            {
                put("Content-Type", "application/json");
                put("Accept", "application/seamless.app.resource-1.2+json");
            }
        };
        
        given()
                .headers(requestHeaders)
                .body(postBody)
        .when()
                .post(envConfig.getProperty("m_endpoint-path"))
        .then()
        .assertThat()
                .statusCode(200).and()
                .header("Content-Type", "application/seamless.app.resource-1.2+json").and()
                .body(containsString("adDatas"));
        
    }
}
