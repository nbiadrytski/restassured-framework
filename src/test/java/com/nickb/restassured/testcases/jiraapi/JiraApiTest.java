package com.nickb.restassured.testcases.jiraapi;

import com.nickb.restassured.base.BaseTest;
import com.nickb.restassured.utils.TestUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class JiraApiTest extends BaseTest{
    
    @Test
    public void checkJiraApiTest() {

        RestAssured.baseURI = "http://localhost:8080";
        
        Response resp = given().log().all().
                header("Content-Type", "application/json").header("Cookie", "JSESSIONID-" + TestUtils.getJiraSessionKey()).
                body("{\"fields\": {\n" +
                        "\t\"project\":{\n" +
                        "          \"key\": \"RES\"\n" +
                        "       },\n" +
                        "       \"summary\": \"Creating second bug summary 3\",\n" +
                        "       \"description\": \"Creating second bug description 3\",\n" +
                        "       \"issuetype\": {\n" +
                        "          \"name\": \"Bug\"\n" +
                        "       }\n" +
                        "    }\n" +
                        "}").
                when().post("/rest/api/2/issue").then().log().body().statusCode(201).extract().response();
        
        JsonPath jp = convertResponseToJson(resp);
        String id = jp.get("id");
        System.out.println(id);
        
                
        
        
                
        
    }
}
