package com.zxl.LeetCode.Solution;

public class maxProduct {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        long[] maxDp = new long[n + 1];
        long[] minDp = new long[n + 1];
        for (int i = 0; i < n; i++) {
            maxDp[i] = nums[i];
            minDp[i] = nums[i];
        }
        for (int i = 0; i < n - 1; i++) {
            maxDp[i + 1] = Math.max(maxDp[i] * nums[i + 1], Math.max(nums[i + 1], minDp[i] * nums[i + 1]));
            minDp[i + 1] = Math.min(maxDp[i] * nums[i + 1], Math.min(nums[i + 1], minDp[i] * nums[i + 1]));
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            ans = Math.max(ans, (int)maxDp[i]);
        }
        return ans;
    }
}
