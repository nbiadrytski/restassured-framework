package com.nickb.restassured.base;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.json.XML;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    protected Properties envConfig = new Properties();
    private String envConfigPath = "src/test/resources/properties/env.properties";
    private FileInputStream fileStream;

    @BeforeTest
    public void setUp() throws IOException {

        fileStream = new FileInputStream(envConfigPath);
        envConfig.load(fileStream);
        
    }

    /* convert Response(xml) response to string
    then convert string to JSONObject object
    get required field and convert it to string*/
    protected static String getUuidFromVmapConvertedToJson(Response response) {
        
        String responseString = response.asString();
        JSONObject jsonResult = XML.toJSONObject(responseString);
        JSONObject contentTag = jsonResult.getJSONObject("vmap:VMAP").getJSONObject("vmap:Extensions").
                getJSONObject("smls:extensions").getJSONObject("smls:content");
        return contentTag.getString("contextId");
    }
    
    // convert Response (rest-assured) response to xml
    protected static XmlPath convertResponseToXml(Response response) {
        
        String responseString = response.asString();
        return new XmlPath(responseString);
    }

    // convert Response (rest-assured) response to JSON
    protected static JsonPath convertResponseToJson(Response response) {
        
        String responseString = response.asString();
        return new JsonPath(responseString);
    }

}
