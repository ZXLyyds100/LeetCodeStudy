package com.zxl.LeetCode.Solution;

import java.util.Deque;
import java.util.LinkedList;

public class dailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int now = temperatures[i];
            while (!stack.isEmpty() && now > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
