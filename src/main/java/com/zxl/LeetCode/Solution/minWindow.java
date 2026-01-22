package com.zxl.LeetCode.Solution;

// s中最短的包含t中所有字符的子串
public class minWindow {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int[] tCnt = new int[128];
        int[] winCnt = new int[128];
        for (char c : tArr) {
            tCnt[c]++;
        }
        int left = 0, right = 0;
        int cnt = 0;
        int begin = 0;
        int minLen = sLen + 1;
        for (int i = 0; i < sLen; i++) {
            char c = sArr[i];
            if (tCnt[c] == 0) {
                right++;
                continue;
            }
            if (winCnt[c] < tCnt[c]) {
                cnt++;
            }
            winCnt[c]++;
            right++;
            while (cnt == tLen) {
                if (right - left < minLen) {
                    begin = left;
                    minLen = right - left;
                }
                char leftChar = sArr[left];
                if (tCnt[leftChar] == 0) {
                    left++;
                    continue;
                }
                if (tCnt[leftChar] == winCnt[leftChar]) {
                    cnt--;
                }
                winCnt[leftChar]--;
                left++;
            }
        }
        if (minLen == sLen + 1) {
            return "";
        }
        return s.substring(begin, begin + minLen);
    }
}
