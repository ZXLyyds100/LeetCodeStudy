package com.zxl.LeetCode.Solution;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class largestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];// 第i个柱子左边第一个比它小的柱子的位置
        int[] right = new int[n];// 第i个柱子右边第一个比它小的柱子的位置
        Deque<Integer> stack = new ArrayDeque<>();//单调递增栈
        /*for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }*/
        Arrays.fill(right, n);
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.peek()] = i;
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
