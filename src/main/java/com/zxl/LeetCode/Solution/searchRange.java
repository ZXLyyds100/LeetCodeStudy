package com.zxl.LeetCode.Solution;

public class searchRange {
    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;
        int left = 0, right = nums.length - 1;
        // 这就是左闭右闭区间，循环中能找到，然后用right=mid-1和left=mid+1进行划分
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                first = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{first, last};

    }
    // 这个就是第二种写法，左闭右开的
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int n = nums.length;
            if (n == 0) return new int[]{-1, -1};

            // 找 first：第一个 >= target
            int left = 0, right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            // 如果不存在 target
            if (left == n || nums[left] != target) {
                return new int[]{-1, -1};
            }
            int first = left;

            // 找 last：第一个 > target
            left = 0;
            right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            int last = left - 1;

            return new int[]{first, last};
        }
    }

}
