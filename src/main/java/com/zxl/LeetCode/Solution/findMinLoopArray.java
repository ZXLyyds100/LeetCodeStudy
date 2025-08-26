package com.zxl.LeetCode.Solution;

public class findMinLoopArray {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while(l < r){
            int mid = (r - l) / 2 + l;
            if(nums[mid] < nums[l]){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
