package com.leetcode.easy;

import com.leetcode.easy.TestClass.InnerTestClass;

/**
 * Created by arthur.hw on 2019/5/7.
 */
public class AnotherTestClass {
    public static void main(String[] args){
        InnerTestClass innerTestClass = (new TestClass()).new InnerTestClass();
        innerTestClass.say();
    }
}
