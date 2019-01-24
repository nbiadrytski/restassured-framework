package com.nickb.restassured.utils;

public class LibraryApiTestUtils {

    public static String addBookPayload(String name, String isbn, String aisle, String author) {
        String payload = "{\"name\":" + "\"" + name + "\"" + ",\"isbn\":" + "\"" + isbn + "\"" + ",\"aisle\":" + "\"" + aisle + "\"" + ",\"author\":" + "\"" + author + "\"" + "}";
        return payload;
    }
}
