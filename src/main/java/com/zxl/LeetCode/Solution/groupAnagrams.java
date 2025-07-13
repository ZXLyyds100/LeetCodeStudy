package com.zxl.LeetCode.Solution;

import java.util.*;

public class groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>mp=new HashMap<>();
        for(String str:strs){
            char[]c=str.toCharArray();
            Arrays.sort(c);
            String key=String.valueOf(c);
            List<String>value=mp.getOrDefault(key,new ArrayList<>());
            value.add(str);
            mp.put(key,value);
        }
        List<List<String>>res=new ArrayList<>(mp.values());
        return res;
        }
}

