package com.zxl.LeetCode.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class longestPalinrome {
    //1、使用二维dp解决最长回文子串问题，这里子串在原串中必须连续
    /*public String longestPalindrome(String s) {
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

    }*/
    //2、使用中心扩展法解决，和1的时间复杂度相同
   /* public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }*/
    public class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            if (n == 0) return "";  // 如果字符串为空，直接返回空

            int right = -1; // 当前回文串能到达的最远右边界
            int j = -1;     // right对应的中心
            StringBuffer temp = new StringBuffer();

            // 插入分隔符 '#'，处理奇偶回文的统一情况
            temp.append("#");
            for (int i = 0; i < n; i++) {
                temp.append(s.charAt(i));
                temp.append("#");
            }
            temp.append("#");
            s = temp.toString();  // 处理后的字符串
            n = s.length();

            List<Integer> arm_len = new ArrayList<>(); // 存储每个位置的回文半径
            int start = 0; // 最长回文子串的起始位置
            int end = 0;   // 最长回文子串的结束位置

            for (int i = 0; i < n; i++) {
                int current;

                // 情况1：i 在 right 以内
                if (i <= right) {
                    int sym_i = 2 * j - i; // 计算 i 的对称点
                    int min_sym_len = Math.min(arm_len.get(sym_i), right - i); // 取较小的回文半径
                    current = expand(s, i - min_sym_len, i + min_sym_len); // 向外扩展
                } else {
                    current = expand(s, i, i); // 直接从当前位置扩展
                }

                arm_len.add(current); // 存储回文半径

                // 更新右边界和中心
                if (i + current > right) {
                    right = i + current;
                    j = i;
                }

                // 更新最长回文子串的起始和结束位置
                if (2 * current + 1 > end - start) {
                    start = i - current;
                    end = i + current;
                }
            }

            // 提取最长回文子串
            StringBuffer result = new StringBuffer();
            for (int i = start; i <= end; i++) {
                if (s.charAt(i) != '#') {
                    result.append(s.charAt(i));
                }
            }
            return result.toString();
        }

        // 扩展函数：从给定的左右位置向两边扩展，寻找最长回文
        public int expand(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return (right - left - 1) / 2; // 返回回文半径
        }
    }

}
