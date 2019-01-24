package com.nickb.restassured.utils;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestUtils {
    
    public static String convertJsonFromFileToString(String filePath) throws IOException {

        InputStream inStream = new FileInputStream(filePath);
        return IOUtils.toString(inStream, "UTF-8");
    }
}
