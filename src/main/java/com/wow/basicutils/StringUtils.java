package com.wow.basicutils;

/**
 * utils for class:java.lang.String
 * <p>
 * Created by kisrosen on 17/2/8.
 */
public class StringUtils {

    /**
     * trim the end character of the sourceString
     *
     * @param sourceString
     * @param trimChar
     * @return
     */
    public static String trimEnd(String sourceString, String trimChar) {
        return sourceString.endsWith(trimChar) ?
                trimEnd(sourceString.substring(0, sourceString.length() - 1), trimChar) :
                sourceString;
    }
}
