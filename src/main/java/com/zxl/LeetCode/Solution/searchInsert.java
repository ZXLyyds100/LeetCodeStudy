package com.zxl.LeetCode.Solution;


public class searchInsert {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else if(nums[mid] > target) {
                right = mid - 1;
            }
        }
        // 最终的left == right是第一个>=target的index，如果全都<target，那就返回left + 1
        return nums[left] < target ? left + 1 : left;
    }
}
