package com.zxl.LeetCode.Solution;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。



示例 1:

输入: s = "cbaebabacd", p = "abc"
输出: [0,6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
示例 2:

输入: s = "abab", p = "ab"
输出: [0,1,2]
解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。


提示:

        1 <= s.length, p.length <= 3 * 104
s 和 p 仅包含小写字母*/
public class findAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();
        int sLen = s.length();
        if (sLen < pLen)return new ArrayList<>();
        int[] pCnt = new int[26];
        int[] sCnt = new int[26];
        for (int i = 0; i < pLen; i++) {
            sCnt[s.charAt(i) - 'a']++;
            pCnt[p.charAt(i) - 'a']++;
        }
        List<Integer> ans = new ArrayList<>();
        if (Arrays.equals(pCnt, sCnt)) {
            ans.add(0);
        }
        for (int i = 0; i < sLen - pLen; i++) {
            sCnt[s.charAt(i) - 'a']--;
            sCnt[s.charAt(i + pLen) - 'a']++;
            if (Arrays.equals(pCnt, sCnt)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
