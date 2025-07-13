package com.zxl.LeetCode.Solution;

public class firstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        // 如果数组中出现<=0或者>=n+1的数就会导致1-n之间的某个或者某些数的缺失
        // 那么缺失的第一个整数必须是1-n+1之间
        // 那么思路就是遍历数组每个数字，如果这个数字<=0或者>=n+1的数都标记为1，当然得先看1是否在数组里面
        // 接下来对下标i，把下标i对应的值j作为下标，把j下标的值先做绝对值再取-，然后再遍历看哪个下标k对应的值为正数，返回i+1
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<=0){
                nums[i]=n+1;
            }
        }
        for(int i=0;i<n;i++){
            int num=Math.abs(nums[i]);
            if(num<=n){
                nums[num-1]=-Math.abs(nums[num-1]);
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                return i+1;
            }
        }
        return n+1;
    }
}
