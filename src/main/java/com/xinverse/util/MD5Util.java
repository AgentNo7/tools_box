package com.xinverse.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    private static String byteArray2HexString(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(b & 0xff);
            if (hex.length() == 1) {
                stringBuilder.append("0").append(hex);
            }else {
                stringBuilder.append(hex);
            }
        }
        return stringBuilder.toString();
    }

    private static String encode(String origin, String algorithm, String charset) {
        String result = null;
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            if (charset == null || charset.equals("")) {
                result = byteArray2HexString(md.digest(origin.getBytes()));
            } else {
                result = byteArray2HexString(md.digest(origin.getBytes(charset)));
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String MD5EncodeUtf8(String origin) {
        return encode(origin, "MD5", "utf-8");
    }

    public static String SHA1EncodeUtf8(String origin) {
        return encode(origin, "SHA-1", "utf-8");
    }
    public static String SHA256EncodeUtf8(String origin) {
        return encode(origin, "SHA-256", "utf-8");
    }

    public static void main(String[] args) {
        String a = "aaa";//"aa";
        System.out.println(MD5EncodeUtf8(a));
        System.out.println(SHA1EncodeUtf8(a));
        System.out.println(SHA256EncodeUtf8(a));
    }
}
