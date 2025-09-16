package com.zxl.LeetCode.Solution;
// [1,2,3] -> [1,3,2]
public class nextPermutation {
    // 找到紧挨着的下一个排列，找不到就用初始排序
    // 思路很简单
    // 简单说就是从右向左找到未被操作的第一个idx：i，也就是说还没逆序的第一个下标，那么由于是第一个
    // ，这就意味着i+1到末尾是逆序的，不用去管
    // 接下来再从右向左寻找第一个>nums[i]的下标j，然后swap，接下来由于是要紧挨着，就把i+1到末尾的值排序即可，也就是逆序
        public void nextPermutation(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }
            int i = nums.length - 2;
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }
            if (i >= 0) {
                int j = nums.length - 1;
                while (j >= 0 && nums[i] >= nums[j]) {
                    j--;
                }
                swap(nums, i, j);
            }
            reverse(nums, i + 1);
        }
        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        public void reverse(int[] nums, int start) {
            int right = nums.length - 1;
            int left = start;
            while (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
}
