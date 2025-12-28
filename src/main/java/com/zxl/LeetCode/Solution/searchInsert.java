package com.zxl.LeetCode.Solution;


public class searchInsert {
    public int searchInsert(int[] nums, int target) {
        // 俩中模板，一种左闭右闭区间[l,r]，也就是现在的写法
        // left必须<=right,然后left = mid + 1，right = mid - 1
        // 循环结束时left时第一个>target的值
        // right是第一个<target的值
        // 此时left > right
        //left=0, right=size-1
        //判断是否存在必须在循环中判断,也就是nums[mid]==target
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public int searchInsert2(int[] nums, int target) {
        // 这种是左闭右开区间，left < right,right=size
        // 循环结束后的left == right，并且都是第一个>或者>=target的值，判断是否存在需要在循环外判断
        // left要小于size并且nums[left]==target才存在
        // 并且要记住[left,right)
        // 当nums[mid]<target的时候left=mid+1,此时区间不会出问题
        // 如果nums[mid]<=target的时候left=mid + 1,区间就出问题了，因为是左边是闭合的所以如果
        // 恰好nums[left]==target的话就不在这区间了
        // 对于第一个if判断，如果nums[left]<target，left=mid+1，否者right=mid，那么就是找第一个>或者>=target的值
        // 如果是nums[left]<=target那就是第一个大于target的值
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
