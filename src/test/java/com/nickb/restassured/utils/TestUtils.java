package com.nickb.restassured.utils;

import com.nickb.restassured.base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static io.restassured.RestAssured.given;

public class TestUtils extends BaseTest{
    
    public static String convertJsonFromFileToString(String filePath) throws IOException {

        InputStream inStream = new FileInputStream(filePath);
        return IOUtils.toString(inStream, "UTF-8");
    }
    
    public static String getJiraSessionKey() {

        RestAssured.baseURI = "http://localhost:8080";

        // create session
        Response resp = given().
                header("Content-Type", "application/json").
                body("{\"username\": \"nickbiadrytski\", \"password\": \"102Nic!!!\"}").
                when().
                post("/rest/auth/1/session").
                then().statusCode(200).extract().response();

        JsonPath jp = convertResponseToJson(resp);
        String sessionId = jp.get("session.value");
        return sessionId;
    }
}
