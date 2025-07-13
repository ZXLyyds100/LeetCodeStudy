package com.zxl.LeetCode.Solution;

public class maxSubArray {
    public int maxSubArray(int[] nums) {
        int maxSub=nums[0];
        int pre=0;
        for(int x:nums){
            pre=Math.max(pre+x,x);
            maxSub=Math.max(pre,maxSub);
        }
        return maxSub;
    }
}
