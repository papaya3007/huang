package me.ordersystem.huang.utils;

import java.security.MessageDigest;
import java.util.Scanner;

//md5 加密类

public class MD5Util {
    //加密私盐
    //private static final String SALT = "adminAccount";

    //私盐使用用户名
    public static String encode(String password, String SALT) {
        password = password + SALT;
        return processEncode(password);
    }

    public static String processEncode(String password) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        char[] charArray = password.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }

            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }


}