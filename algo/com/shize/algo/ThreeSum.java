package com.shize.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shize
 */
class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        // -2 -1 -1 0 1 2 4
        // 0   1  2 3 4 5 6
        List<List<Integer>> res = new ArrayList<>();
        for (int a = 0; a < nums.length - 2 ; a++) {
            // 如果最小的数都大于0，那么后面的数肯定都大于0，不可能有三个数相加等于0
            if (nums[a] > 0) {
                break;
            }
            // 去重
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }

            int b = a + 1;
            int c = nums.length - 1;

            while (b < c) {
                int sum = nums[a] + nums[b] + nums[c];
                if (sum == 0) {
                    // 去重
                    res.add(Arrays.asList(nums[a], nums[b], nums[c]));
                    while (b < c && nums[b] == nums[b + 1]) {
                        b++;
                    }
                    while (b < c && nums[c] == nums[c - 1]) {
                        c--;
                    }
                    b++;
                    c--;
                } else if (sum < 0) {
                    b++;
                } else {
                    c--;
                }
            }

        }

        return res;
    }
}
