package com.zxl.LeetCode.Solution;

public class findMinLoopArray {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}
