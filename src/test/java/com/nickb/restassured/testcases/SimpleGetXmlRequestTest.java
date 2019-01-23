package com.nickb.restassured.testcases;

import com.nickb.restassured.base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.config.XmlPathConfig;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class SimpleGetXmlRequestTest extends BaseTest{

    @Test
    public void checkMicaXmlResponseTest() throws IOException {

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

        //XmlPath xmlPath = new XmlPath(responseString).using(XmlPathConfig.xmlPathConfig()).
        //XmlPath xmlPath = new XmlPath(responseString).using(XmlPathConfig.xmlPathConfig().declaredNamespace("smls", "http://seamless.net/smls"));
        //XmlPath xmlPath = new XmlPath(responseString).using(XmlPathConfig.xmlPathConfig().namespaceAware(false));
        //xmlPath.setRoot()
        //System.out.println(xmlPath.getString("vmap:VMAP.vmap:Extensions.smls:content"));
        //System.out.println(xmlPath.getString("vmap:VMAP.vmap:Extensions.smls:content.@contentUri"));

        //XmlPath micaXml = new XmlPath(responseString);
        //System.out.println("-----------" + micaXml.get(".//content[@contentUri]"));
        //System.out.println("-------------------" + uuid);

        // gut seamless uuid
        //JsonPath micaJson = new JsonPath(responseString);
        //String documentid = micaJson.get("documentid");

        // call master.m3u8 with extracted uuid
        /*given().relaxedHTTPSValidation().param("proxy", false).
                when().get(envConfig.getProperty("s_endpoint-path") + documentid + "/master.m3u8").
                then().assertThat().statusCode(200).and().
                body(containsString("#EXTM3U"));*/

    }
}
