package com.wow.basicutils;

/**
 * Created by kisrosen on 17/2/17.
 */
public class AssertRules {
    /**
     * IP Address
     */
    public static final String IP_PTN = "((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))";

    /**
     * Cell Number
     */
    public static final String CELL_PTN = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";

    /**
     * Chinese Identity Number
     */
    public static final String IDENTITY_PTN = "^\\d{15}|\\d{18}$";

    /**
     * Chinese Phone Number
     */
    public static final String CHINA_PHONE_PTN = "\\d{3}-\\d{8}|\\d{4}-\\d{7}";

    /**
     * Chinese Character
     */
    public static final String CHINESE_PTN = "[u4e00-u9fa5]";

    /**
     * Email Address
     */
    public static final String EMAIL_PTN = "w+([-+.]w+)*@w+([-.]w+)*.w+([-.]w+)*";
}
