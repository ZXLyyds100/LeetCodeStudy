package com.zxl.LeetCode.Solution;

public class longestValidParentheses {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int longest = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2;
                    int preIndex = i - dp[i - 1] - 2;
                    if (preIndex >= 0) {
                        dp[i] += dp[preIndex];
                    }
                }
            }
            longest = Math.max(longest, dp[i]);
        }
        return longest;
    }
}
