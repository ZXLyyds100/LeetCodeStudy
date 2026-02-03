package com.zxl.LeetCode.Solution;

public class jump {
    public int jump_1(int[] nums) {
        int pos = nums.length - 1;
        int steps = 0;
        while (pos > 0) {
            for (int i = 0; i < pos; i++) {
                if (pos <= i + nums[i]) {
                    steps++;
                    pos = i;
                    break;
                }
            }
        }
        return steps;
    }

    public int jump_2(int[] nums) {
        int maxPos = 0;
        int n = nums.length;
        int step = 0;
        int end = 0;
        for (int i = 0; i < n - 1; i++) {
            maxPos = Math.max(maxPos, nums[i] + i);
            if (i == end) {
                end = maxPos;
                step++;
                if (end >= n - 1) {
                    break;
                }
            }
        }
        return step;

    }
}
