package com.zxl.LeetCode.Solution;

public class sortColors2 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                swap(i, p1, nums);
                p1++;
            } else if (nums[i] == 0) {
                swap(i, p0, nums);
                if (p0 < p1) {
                    swap(i, p1, nums);
                }
                p0++;
                p1++;
            }
        }
    }

    public void swap(int i, int j, int nums[]) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
