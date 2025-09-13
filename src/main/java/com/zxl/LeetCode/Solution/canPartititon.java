package com.zxl.LeetCode.Solution;

public class canPartititon {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int target = 0;
        int maxNum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            maxNum = Math.max(maxNum, nums[i]);
        }
        if (sum % 2 == 1) {
            return false;
        }
        target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }
}
