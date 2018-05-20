package com.example.aviro.noncecalculator;

import java.security.MessageDigest;

/**
 * Created by aviro on 5/20/2018.
 */

public class md5 {

    public static String encryptMD5(byte[] data) throws Exception {

        String hashValue = "";
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(data);
        byte[] DigestedByte = md.digest();
        return Utils.byteArrayToHexString(DigestedByte);


    }

    public static class Utils {

        public static String scrape(String resp, String start, String stop) {
            int offset, len;
            if ((offset = resp.indexOf(start)) < 0)
                return "";
            if ((len = resp.indexOf(stop, offset + start.length())) < 0)
                return "";
            return resp.substring(offset + start.length(), len);
        }


        public static String byteArrayToHexString(byte[] array) {
            StringBuffer hexString = new StringBuffer();
            for (byte b : array) {
                int intVal = b & 0xff;
                if (intVal < 0x10)
                    hexString.append("0");
                hexString.append(Integer.toHexString(intVal));
            }
            return hexString.toString();
        }
    }
}