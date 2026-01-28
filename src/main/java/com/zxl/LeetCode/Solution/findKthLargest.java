package com.zxl.LeetCode.Solution;
class findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) return 0;
        quick_sort(nums, 0, nums.length - 1);
        return nums[nums.length - k]; // 第 k 大是倒数第 k 个
    }

    public void quick_sort(int[] nums, int l, int r) {
        if (l >= r) return;
        int i = l, j = r;
        int x = nums[l + (r - l) / 2];
        while (i <= j) {
            while (nums[i] < x) i++;
            while (nums[j] > x) j--;
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                j--;
                i++;
            }

        }
        quick_sort(nums, l, j);
        quick_sort(nums, j + 1, r);
    }
}
