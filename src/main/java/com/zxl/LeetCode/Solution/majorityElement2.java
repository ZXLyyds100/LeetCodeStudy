package com.zxl.LeetCode.Solution;

public class majorityElement2 {
    public int countElement(int[] nums, int num, int l, int r) {
        int cnt = 0;
        for (int i = l; i <= r; i++) {
            if (nums[i] == num) {
                cnt++;
            }
        }
        return cnt;
    }
    public int getMajorityElement(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int mid = (r - l) / 2 + l;
        int left = getMajorityElement(nums, l, mid);
        int right = getMajorityElement(nums, mid + 1, r);
        if (left == right) {
            return left;
        }
        int leftCount = countElement(nums, left, l, r);
        int rightCount = countElement(nums, right, l, r);
        return leftCount > rightCount ? left : right;
    }
    public int majorityElement(int[] nums) {
        return getMajorityElement(nums, 0, nums.length - 1);
    }
}
