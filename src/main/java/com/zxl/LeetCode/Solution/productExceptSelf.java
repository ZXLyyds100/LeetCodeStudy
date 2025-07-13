package com.zxl.LeetCode.Solution;

public class productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n+5];
        ans[0]=1;
        for(int i=1;i<n;i++){
            ans[i]=ans[i-1]*nums[i-1];
        }// ans先处理前缀积
        int r=1;
        for(int i=n-1;i>=0;i--){
            ans[i]=ans[i]*r;
            r*=nums[i];
        }// 然后处理后缀积
        return ans;
    }
}
