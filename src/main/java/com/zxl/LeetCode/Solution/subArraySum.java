package com.zxl.LeetCode.Solution;

import java.util.HashMap;
import java.util.Map;

public class subArraySum {
    public int subarraySum(int[] nums, int k) {
        //总结思路就是，题目要求 k==pre[i]-pre[j-1]个数，也就是pre[i]-k==pre[j]那么只要顺序枚举每个下标前缀和-k是否存在于mp中（mp的key是pre值，value是出现次数）
        int n=nums.length;
        Map<Integer,Integer> mp=new HashMap<>();
        mp.put(0,1);
        int pre=0;
        int count=0;
        for(int i=0;i<n;i++){
            pre+=nums[i];
            if(mp.containsKey(pre-k)){
                count+=mp.get(pre-k);
            }
            mp.put(pre,mp.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
