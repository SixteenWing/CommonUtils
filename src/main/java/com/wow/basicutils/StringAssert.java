package com.wow.basicutils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Common String Validate Handler Based On Regular Expression
 * <p>
 * Created by kisrosen on 17/2/17.
 */
public class StringAssert {

    private static Pattern pattern;

    /**
     * Assert Is Ip Or Not
     *
     * @param inStr
     * @return
     */
    public static boolean assertIsIp(String inStr) {

        pattern = Pattern.compile(AssertRules.IP_PTN);

        return AssertIsTrue(inStr);
    }

    /**
     * Assert Is Cell Number Or Not
     *
     * @param inStr
     * @return
     */
    public static boolean assertIsCell(String inStr) {

        pattern = Pattern.compile(AssertRules.CELL_PTN);

        return AssertIsTrue(inStr);
    }

    /**
     * Assert Is Identity Number Or Not
     *
     * @param inStr
     * @return
     */
    public static boolean assertIsIdentity(String inStr) {
        pattern = Pattern.compile(AssertRules.IDENTITY_PTN);

        return AssertIsTrue(inStr);
    }

    /**
     * Assert Is Chinese Phone Number(Not Cell Number) Or Not
     *
     * @param inStr
     * @return
     */
    public static boolean assertIsChinesePhone(String inStr) {
        pattern = Pattern.compile(AssertRules.CHINA_PHONE_PTN);

        return AssertIsTrue(inStr);
    }

    /**
     * Assert Is Chinese Characters Or Not
     *
     * @param inStr
     * @return
     */
    public static boolean assertIsChineseLetter(String inStr) {
        pattern = Pattern.compile(AssertRules.CHINESE_PTN);

        return AssertIsTrue(inStr);
    }

    /**
     * Assert Is Email Address
     *
     * @param inStr
     * @return
     */
    public static boolean assertIsEmail(String inStr) {
        pattern = Pattern.compile(AssertRules.EMAIL_PTN);

        return AssertIsTrue(inStr);
    }

    /**
     * Assert Is The Input String Matched
     *
     * @param inStr
     * @return
     */
    protected static boolean AssertIsTrue(String inStr) {
        Matcher ma = pattern.matcher(inStr);

        if (ma.find()) {
            return true;
        }

        return false;
    }
}
