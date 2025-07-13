package com.zxl.LeetCode.Solution;

import java.util.HashSet;
import java.util.Set;

/*给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。*/
/*


示例 1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。


提示：

        0 <= s.length <= 5 * 104
s 由英文字母、数字、符号和空格组成*/
public class lenghtOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Set<Character>set=new HashSet<>();
        int ans=0;
        int n=s.length();
        int st=0;
        int end=0;
        for(int i=0;i<n;i++){
            if(i!=0){
                set.remove(chars[i-1]);
            }
            while(end<n&&!set.contains(chars[end])){
                set.add(chars[end]);
                end++;
            }
            ans=Math.max(ans,end-i);
        }
        return ans;
    }

}
