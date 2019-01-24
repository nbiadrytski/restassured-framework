package com.nickb.restassured.testcases;

import com.nickb.restassured.base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TraverseJsonTest extends BaseTest {
    
    @Test
    public void checkTraverseJsonTest() throws IOException {

        ArrayList<String> chapters = new ArrayList<String>();

        RestAssured.baseURI = envConfig.getProperty("s_prod-https");

        Response resp = given().log().all().relaxedHTTPSValidation().
            param("SMADnoads", true).
        when().
            get(envConfig.getProperty("s_ep_endpoint-path") + "mica.json").
        then().log().all().
        assertThat().
            statusCode(200).and().
            contentType(ContentType.JSON).and().
            body("stitchedstream.cdn", equalTo("akamai")).and().
            header("Server","nginx/1.10.1").
        extract().response();
                
        JsonPath nicaJson = convertResponseToJson(resp);
        
        // get size of chapters array
        int chaptersNumber = nicaJson.get("content[0].chapters.size()");
        
        // store each chapter id in chapters ArrayList
        for(int i = 0; i < chaptersNumber; i++) {
            String chapterId = nicaJson.get("content[0].chapters[" + i + "]" + ".id");
            chapters.add(chapterId);
        }
        
        System.out.println(chapters);
        System.out.println(chapters.get(0));

        // TestNG assert
        Assert.assertEquals(chapters.get(0), "mgid:arc:video:central:825e3a66-52a3-4458-84fc-27a7a7bc0638");
                
    }
    
}
