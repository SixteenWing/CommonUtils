package com.leetcode.easy;

/**
 * Created by arthur.hw on 2018/12/13.
 *
 * num.7  https://leetcode-cn.com/problems/reverse-integer/
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

 示例 1:

 输入: 123
 输出: 321
 示例 2:

 输入: -123
 输出: -321
 示例 3:

 输入: 120
 输出: 21
 注意:

 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 *
 */
public class ReverseInteger {
    public int reverse(int x) {

        boolean isM = false;
        if (x < 0) {
            x = Math.abs(x);
            isM = true;
        }

        String xStr = String.valueOf(x);
        char[] xStrArr = xStr.toCharArray();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < xStrArr.length; i++) {
            sb.append(xStrArr[i]);
        }
        xStr = sb.reverse().toString();

        try {
            x = isM ? -Integer.parseInt(xStr) : Integer.parseInt(xStr);
            return x;
        }catch (Exception ex){
            return 0;
        }
    }

    public static void main(String[] args) {
        int x = 2147483647;

        ReverseInteger client = new ReverseInteger();

        System.out.println(client.reverse(x));
    }
}

