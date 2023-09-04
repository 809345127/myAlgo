package com.shize.algo;


public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        // 6 5 4 3 2 1
        // 0 1 2 3 4 5
        int n = nums.length;

        // 1. 将所有小于等于0的数替换为n+1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 ) {
                nums[i] = n + 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            // 原地哈希， 比如说第一个值等于5 那就把第五个值即第4个下标的值变成负数
            int absVal = Math.abs(nums[i]);
            if (absVal <= n) {
                nums[absVal - 1] = -Math.abs(nums[absVal - 1]);
            }

        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i+1;
            }
        }

        return n + 1;
    }
}
