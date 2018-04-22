package com.xinverse.util;

import java.util.UUID;

public class UUIDUtil {

    public static String UUID(){
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        System.out.println(UUID());
    }
}
