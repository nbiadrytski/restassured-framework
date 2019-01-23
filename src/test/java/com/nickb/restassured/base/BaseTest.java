package com.nickb.restassured.base;


import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    protected Properties envConfig = new Properties();
    private String propConfigPath = "src/test/resources/properties/env.properties";
    private FileInputStream fileStream;

    @BeforeTest
    public void setUp() throws IOException {

        fileStream = new FileInputStream(propConfigPath);
        envConfig.load(fileStream);
        
    }

}
