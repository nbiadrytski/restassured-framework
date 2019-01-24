package com.nickb.restassured.testcases.library_api;

import com.nickb.restassured.base.BaseTest;
import com.nickb.restassured.utils.LibraryApiTestUtils;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class DynamicJsonTest extends BaseTest{
    
    @Test
    public void addBookTest() {

        RestAssured.baseURI = "http://216.10.245.166";

        Response resp = given().log().all().
            header("Content-Type", "application/json").
            body(LibraryApiTestUtils.addBookPayload("The Sea", "asdfvasv", "666888", "Kim Bartek")).
            when().
                post("/Library/Addbook.php").
            then().log().all().assertThat().statusCode(200).
                extract().response();

        JsonPath jp = convertResponseToJson(resp);
        
        String id = jp.get("ID");
        
        System.out.println(id);
                
    }
}
