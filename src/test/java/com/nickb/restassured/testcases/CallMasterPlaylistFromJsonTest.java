package com.nickb.restassured.testcases;

import com.nickb.restassured.base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class CallMasterPlaylistFromJsonTest extends BaseTest {

    @Test
    public void checkMasterPlaylistFromJsonTest() throws IOException {
        
        RestAssured.baseURI = envConfig.getProperty("s_prod-https");
        Response resp = given().

        given().relaxedHTTPSValidation().param("SMADnoads", true).
                when().get(envConfig.getProperty("s_endpoint-path") + "mica.json").
                then().assertThat().statusCode(200).and().
                contentType(ContentType.JSON).and().
                body("stitchedstream.cdn", equalTo("akamai")).and().
                header("Server","nginx/1.10.1").
                extract().response();
        
        JsonPath micaJson = convertResponseToJson(resp);
        String uuid = micaJson.get("documentid");
        
        // call master.m3u8 with extracted uuid
        given().relaxedHTTPSValidation().param("proxy", false).
                when().get(envConfig.getProperty("s_endpoint-path") + uuid + "/master.m3u8").
                then().assertThat().statusCode(200).and().
                body(containsString("#EXTM3U"));

    }
}
