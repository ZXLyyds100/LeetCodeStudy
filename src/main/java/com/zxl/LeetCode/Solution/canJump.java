package com.zxl.LeetCode.Solution;

public class canJump {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightMost = 0;
        for(int i = 0; i < n; i++){
            if(i <= rightMost) {
                rightMost = Math.max(rightMost, nums[i] + i);
                if (rightMost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
