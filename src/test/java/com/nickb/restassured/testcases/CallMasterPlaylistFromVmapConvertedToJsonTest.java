package com.nickb.restassured.testcases;

import com.nickb.restassured.base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class CallMasterPlaylistFromVmapConvertedToJsonTest extends BaseTest {

    @Test
    public void checkMasterPlaylistFromVmapConvertedToJsonTest() {

        RestAssured.baseURI = envConfig.getProperty("s_prod-https");
        Response resp = given().relaxedHTTPSValidation().
                param("SMADnoads", true).
                when().
                get(envConfig.getProperty("s_endpoint-path") + "vmap.xml").
                then().
                assertThat().statusCode(200).and().
                contentType(ContentType.XML).and().
                extract().response();

        String uuid = getUuidFromVmapConvertedToJson(resp);

        // call master.m3u8 with extracted uuid
        given().relaxedHTTPSValidation().param("proxy", false).
                when().get(envConfig.getProperty("s_endpoint-path") + uuid + "/master.m3u8").
                then().assertThat().statusCode(200).and().
                body(containsString("#EXTM3U"));

    }
}
