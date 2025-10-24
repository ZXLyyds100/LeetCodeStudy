package com.zxl.LeetCode.Solution;

import java.util.function.Consumer;

public class longestPalinrome {
    //1、使用二维dp解决最长回文子串问题，这里子串在原串中必须连续
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        char[] chs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int start = 0;
        int maxLen = 1;
        for (int L = 2; L <= n; L++) {
            for (int begin = 0; begin < n - L; begin++) {
                int end = begin + L - 1;
                if (end >= n) {
                    break;
                }
                if (chs[begin] != chs[end]) {
                    dp[begin][end] = false;
                } else {
                    if (end - begin < 3) {
                        dp[begin][end] = true;
                    } else {
                        dp[begin][end] = dp[begin + 1][end - 1];
                    }
                }
                if (dp[begin][end] && end - begin + 1 > maxLen) {
                    maxLen = end - begin + 1;
                    start = begin;
                }
            }
        }
        return s.substring(start, start + maxLen);

    }
}
