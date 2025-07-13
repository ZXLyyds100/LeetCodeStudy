package com.zxl.LeetCode.Solution;
// s中最短的包含t中所有字符的子串
public class minWindow {
    public String minWindow(String s, String t) {
        int sLen=s.length();
        int tLen=t.length();
        if(sLen<tLen){
            return "";
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int[] winFreq=new int[128];
        int[] tFreq=new int[128];
        for(char c:tArray){
            tFreq[c]++;
        }
        int left=0,right=0;
        // [left,right)
        int distance=0;
        int begin=0;
        int minLen=sLen+1;
        while(right<sLen){
            if(tFreq[sArray[right]]==0){
                right++;
                continue;
            }
            if(winFreq[sArray[right]]<tFreq[sArray[right]]){
                distance++;
            }
            winFreq[sArray[right]]++;
            right++;
            while(distance==tLen){
                if(right-left<minLen){
                    minLen=right-left;
                    begin=left;
                }
                if(tFreq[sArray[left]]==0){
                    left++;
                    continue;
                }
                if(tFreq[sArray[left]]==winFreq[sArray[left]]){
                    distance--;
                }

                winFreq[sArray[left]]--;
                left++;
            }
        }
        if(minLen==sLen+1){
            return ";";
        }else{
            return s.substring(begin,begin+minLen);
        }
    }
}
