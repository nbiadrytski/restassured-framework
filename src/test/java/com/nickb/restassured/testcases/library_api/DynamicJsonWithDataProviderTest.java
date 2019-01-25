package com.nickb.restassured.testcases.library_api;

import com.nickb.restassured.base.BaseTest;
import com.nickb.restassured.utils.LibraryApiTestUtils;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DynamicJsonWithDataProviderTest extends BaseTest {
    
    @Test(dataProvider = "AddBooksData")
    public void addBookWithDataProviderTest(String name, String isbn, String aisle, String author) {

        RestAssured.baseURI = "http://216.10.245.166";

        Response resp =

                given().log().all().
                        header("Content-Type", "application/json").
                        body(LibraryApiTestUtils.addBookPayload(name, isbn, aisle, author)).

                when().
                        post("/Library/Addbook.php").

                then().log().body().
                        assertThat().statusCode(200).
                        extract().response();

        JsonPath jp = convertResponseToJson(resp);
        String id = jp.get("ID");
        System.out.println(id);
        
    }
    
    @DataProvider(name = "AddBooksData")
    public Object[][] getData() {
        
        return new Object[][] {
                {"The World", LibraryApiTestUtils.generateRandomUuid(), LibraryApiTestUtils.generateRandomUuid(), "Ben Vell"},
                {"The World 2", LibraryApiTestUtils.generateRandomUuid(), LibraryApiTestUtils.generateRandomUuid(), "Ben Vell 3"},
                {"The World 3", LibraryApiTestUtils.generateRandomUuid(), LibraryApiTestUtils.generateRandomUuid(), "Ben Vell 3"}};
        
    }
}
