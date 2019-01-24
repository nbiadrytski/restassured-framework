package com.nickb.restassured.testcases.library_api;

import com.nickb.restassured.base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class ExcelDrivenTest extends BaseTest{
    
    @Test
    public void addBookTest() {

        RestAssured.baseURI = "http://216.10.245.166";

        Response resp = given().log().all().
            header("Content-Type", "application/json").
            body("{\n" +
                    "\"name\":\"Learn Appium Automation with Java\",\n" +
                    "\"isbn\":\"sjdhgvshj\",\n" +
                    "\"aisle\":\"327678\",\n" +
                    "\"author\":\"John Foe\"\n" +
                    "}").
            when().
                post("/Library/Addbook.php").
            then().log().all().assertThat().statusCode(200).
                extract().response();

        JsonPath jp = convertResponseToJson(resp);
        
        String id = jp.get("id");
        
        System.out.println(id);
                
    }
}
