package com.leetcode.easy;

/**
 * Created by arthur.hw on 2018/12/13.
 *
 * num.9  https://leetcode-cn.com/problems/palindrome-number
 *
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class PalindromeJudge {
    public boolean isPalindrome(int x) {
        return this.isPalindromeStr(x);
    }

    private boolean isPalindromeStr2(int x) {
        String xStr = String.valueOf(x);
        StringBuffer sb = new StringBuffer(xStr);
        String xStrReverse = sb.reverse().toString();

        return xStr.equals(xStrReverse);
    }

    private boolean isPalindromeStr(int x) {
        String xStr = String.valueOf(x);

        char[] xStrArr = xStr.toCharArray();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < xStrArr.length; i++) {
            sb.append(xStrArr[i]);
        }

        String xStrReverse = sb.reverse().toString();

        return xStr.equals(xStrReverse);
    }

    public static void main(String[] args) {
        int x = 121;

        PalindromeJudge client = new PalindromeJudge();

        System.out.println(client.isPalindrome(x));
    }
}
