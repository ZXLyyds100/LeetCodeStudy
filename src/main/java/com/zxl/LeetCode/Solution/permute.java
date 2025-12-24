package com.zxl.LeetCode.Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        backtrace(nums.length, output, ans, 0);
        return ans;
    }
    private void backtrace(int n, List<Integer> output, List<List<Integer>> ans, int first) {
        if (first == n) {
            ans.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(output, first, i);
            backtrace(n, output, ans, first + 1);
            Collections.swap(output, first, i);
        }
    }
}
