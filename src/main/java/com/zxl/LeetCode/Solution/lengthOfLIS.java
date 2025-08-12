package com.zxl.LeetCode.Solution;

public class lengthOfLIS {
   /* public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[nums.length];
        int maxLength = 0;
        for(int i = 0;i < n;i++){
            dp[i] = 1;
            for(int j = 0; j < i ; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxLength = Math.max(dp[i], maxLength);
        }
        return maxLength;
    }*/
   public int lengthOfLIS(int[] nums) {
       if(nums.length == 0){
           return 0;
       }
       int n = nums.length;
       int[] q = new int[n + 10];
       q[0] = (int)-2e9;
       int len = 0;
       for(int num : nums){
           int l = 0, r = len;
           while(l < r){
               int mid = l + r + 1 >> 1;

               if(q[mid] < num)l = mid;
               else r = mid - 1;
           }
           q[r + 1] = num;
           len = Math.max(r + 1,len);
       }
       return len;
   }
}
