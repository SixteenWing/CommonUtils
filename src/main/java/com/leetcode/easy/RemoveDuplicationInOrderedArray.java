package com.leetcode.easy;

import java.util.Arrays;

/**
 * Created by arthur.hw on 2018/12/13.
 */
public class RemoveDuplicationInOrderedArray {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            boolean isdelete = false;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    int[] numsNew = new int[nums.length - 1];

                    for (int m = 0; m < numsNew.length; m++) {
                        if (m < j) {
                            numsNew[m] = nums[m];
                        } else {
                            numsNew[m] = nums[m + 1];
                        }
                    }
                    nums = numsNew;
                    isdelete = true;
                    break;
                }

                if (nums[j] > nums[i]) {
                    break;
                }
            }

            if (!isdelete) {
                i++;
            }
        }

        print(nums);

        return nums.length;
    }

    private int[] delete(int[] nums, int j) {

        int[] numsNew = new int[nums.length - 1];

        for (int i = 0; i < numsNew.length; i++) {
            if (i < j) {
                numsNew[i] = nums[i];
            } else {
                numsNew[i] = nums[i + 1];
            }
        }

        return numsNew;
    }

    private void print(int[] nums) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(nums).forEach(i -> sb.append(i + ","));

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};

        RemoveDuplicationInOrderedArray client = new RemoveDuplicationInOrderedArray();

        int len = client.removeDuplicates(nums);

        System.out.println(len);
    }
}