package com.zxl.LeetCode.Solution;

// s中最短的包含t中所有字符的子串
public class minWindow {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen < tLen) {
            return "";
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int[] winCnt = new int[128];
        int[] tCnt = new int[128];
        for (char c : tArray) {
            tCnt[c]++;
        }
        int distance = 0;
        int left = 0, right = 0;
        int minLen = sLen + 1;
        int begin = 0;
        for (int i = 0; i < sLen; i++) {
            char c = sArray[i];
            if (tCnt[c] == 0) {
                right++;
                continue;
            }
            if (winCnt[c] < tCnt[c]) {
                distance++;
            }
            winCnt[c]++;
            right++;
            while (distance == tLen) {
                if (right - left < minLen) {
                    minLen = right - left;
                    begin = left;
                }
                char leftChar = sArray[left];
                if (tCnt[leftChar] == 0) {
                    left++;
                    continue;
                }
                if (tCnt[leftChar] == winCnt[leftChar]) {
                    distance--;
                }
                left++;
                winCnt[leftChar]--;
            }
        }
        if (minLen == sLen + 1) {
            return "";
        }
        return s.substring(begin, begin + minLen);
    }
}
