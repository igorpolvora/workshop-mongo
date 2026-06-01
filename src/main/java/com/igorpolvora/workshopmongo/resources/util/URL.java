package com.igorpolvora.workshopmongo.resources.util;

import java.net.URLDecoder;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.text.SimpleDateFormat;
public class URL {

    public static String decodeParam(String text) {
        try {
            return URLDecoder.decode(text, "UTF_8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static Date convertDate(String textDate, java.util.Date defaultValue) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(textDate);
        } catch (java.text.ParseException e) {
            return defaultValue;
        }
    }
}
