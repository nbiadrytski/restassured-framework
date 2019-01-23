package com.nickb.restassured.testcases;

import com.nickb.restassured.base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SimpleGetRequestTest extends BaseTest {

    @Test
    public void simpleGetRequestTest() {

        RestAssured.baseURI = envConfig.getProperty("s_prod-https");

        given().relaxedHTTPSValidation().param("SMADnoads", true).
                when().get(envConfig.getProperty("s_endpoint-path") + "mica.json").
                then().assertThat().statusCode(200).and().
                contentType(ContentType.JSON).and().
                body("stitchedstream.cdn", equalTo("akamai")).and().
                header("Server","nginx/1.10.1");

    }
}
