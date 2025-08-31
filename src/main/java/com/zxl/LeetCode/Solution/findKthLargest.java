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
        int pivot = nums[l + (r - l) / 2]; // 中点作为基准

        while (i <= j) {
            while (nums[i] < pivot) i++;
            while (nums[j] > pivot) j--;
            if (i <= j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
                j--;
            }
        }

        if (l < j) quick_sort(nums, l, j);
        if (i < r) quick_sort(nums, i, r);
    }
}
