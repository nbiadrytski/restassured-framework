package com.nickb.restassured.testcases;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Demo1 {

    @Test
    public void Test() {

        RestAssured.baseURI = "http://seamless.mtvnservices.com";

        given().param("SMADnoads", true).
                when().get("/api/mgid:arc:video:central:9f3b5370-307c-4a59-b2ce-a4bf06782c17/mica.json").
                then().assertThat().statusCode(200).and()
                .contentType(ContentType.JSON).and().
                body("stitchedstream.cdn", equalTo("akamai")).and().
                header("Server","nginx/1.10.1");

    }
}
