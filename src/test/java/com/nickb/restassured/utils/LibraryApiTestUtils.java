package com.nickb.restassured.utils;

import java.util.UUID;

public class LibraryApiTestUtils {

    public static String addBookPayload(String name, String isbn, String aisle, String author) {
        String payload = "{\"name\":" + "\"" + name + "\"" + ",\"isbn\":" + "\"" + isbn + "\"" + ",\"aisle\":" + "\"" + aisle + "\"" + ",\"author\":" + "\"" + author + "\"" + "}";
        return payload;
    }
    
    public static String generateRandomUuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
