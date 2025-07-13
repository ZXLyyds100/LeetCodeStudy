package com.zxl.LeetCode.Solution;

import java.util.ArrayList;
import java.util.List;

public class findAnagrams_youhua {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen=s.length();
        int pLen=p.length();
        if(sLen<pLen){
            return new ArrayList<Integer>();
        }
        int[]cnt=new int[26];
        for(int i=0;i<pLen;i++){
            cnt[p.charAt(i)-'a']--;
            cnt[s.charAt(i)-'a']++;
        }
        int differ=0;
        for(int i=0;i<26;i++){
            if(cnt[i]!=0)differ++;
        }
        List<Integer>ans=new ArrayList<>();
        if(differ==0){
            ans.add(0);
        }
        for(int i=0;i<sLen-pLen;i++){
            if(cnt[s.charAt(i)-'a']==1){
                differ--;
            }else if(cnt[s.charAt(i)-'a']==0){
                differ++;
            }
            cnt[s.charAt(i)-'a']--;
            if(cnt[s.charAt(i+pLen)-'a']==-1){
                differ--;
            }else if(cnt[s.charAt(i+pLen)-'a']==0){
                differ++;
            }
            ++cnt[s.charAt(i+pLen)-'a'];
            if(differ==0){
                ans.add(i+1);
            }
        }
        return ans;
    }
}
