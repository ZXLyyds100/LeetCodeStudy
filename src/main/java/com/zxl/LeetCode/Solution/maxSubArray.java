package com.zxl.LeetCode.Solution;

public class maxSubArray {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int maxSum = 0;
        for (int num : nums) {
            // 如果前缀和变成负数则果断放弃，否则继续加进去
            // 是上一个前缀和加上改元素，还是从该元素重新开始
            pre = Math.max(pre + num, num);
            maxSum = Math.max(pre, maxSum);
        }
        return maxSum;
    }
}
