package com.nickb.restassured.testcases;

import com.nickb.restassured.base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.json.XML;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class SimpleGetXmlRequestTest extends BaseTest {

    @Test
    public void checkMicaXmlResponseTest() {

        RestAssured.baseURI = envConfig.getProperty("s_prod-https");
        Response resp = given().relaxedHTTPSValidation().
                param("SMADnoads", true).
                when().
                get(envConfig.getProperty("s_endpoint-path") + "vmap.xml").
                then().
                assertThat().statusCode(200).and().
                contentType(ContentType.XML).and().
                extract().response();

        String responseString = resp.asString();

        // convert xml to json
        JSONObject jsonResult = XML.toJSONObject(responseString);
        JSONObject vmap = jsonResult.getJSONObject("vmap:VMAP").getJSONObject("vmap:Extensions").getJSONObject("smls:extensions").getJSONObject("smls:content");
        String uuid = vmap.getString("contextId");
        System.out.println(uuid);

        // call master.m3u8 with extracted uuid
        /*given().relaxedHTTPSValidation().param("proxy", false).
                when().get(envConfig.getProperty("s_endpoint-path") + documentid + "/master.m3u8").
                then().assertThat().statusCode(200).and().
                body(containsString("#EXTM3U"));*/

    }
}
