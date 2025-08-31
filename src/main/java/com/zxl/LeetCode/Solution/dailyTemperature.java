package com.zxl.LeetCode.Solution;

import java.util.Deque;
import java.util.LinkedList;

public class dailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stk = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int now = temperatures[i];
            while(!stk.isEmpty() && now > temperatures[stk.peek()]){
                int prevIndex = stk.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stk.push(i);
        }
        return ans;
    }
}
