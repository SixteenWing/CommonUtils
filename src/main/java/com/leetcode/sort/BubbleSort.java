package com.leetcode.sort;

/**
 * Created by arthur.hw on 2018/12/15.
 */
public class BubbleSort {

    public int[] bubbleSort(int[] nums) {
        return this.ascSort(nums);
    }

    private int[] ascSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        return nums;
    }

    private int[] descSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {

        int[] nums = new int[] {1, 3, 5, 4, 2, 2, 7, 8};

        BubbleSort client = new BubbleSort();

        client.bubbleSort(nums);

        for (int i : nums) {
            System.out.print(i);
        }
    }
}
