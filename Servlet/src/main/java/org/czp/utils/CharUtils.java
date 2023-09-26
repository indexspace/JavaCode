package org.czp.utils;

import java.nio.charset.StandardCharsets;

public class CharUtils {
    public static String fixCharsets(String source) {
        return new String(source.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    }
}
