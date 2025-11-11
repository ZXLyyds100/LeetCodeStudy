package com.zxl.LeetCode.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class merge {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> merged = new ArrayList<>();
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            int L = intervals[i][0];
            if (merged.size() == 0 || L > merged.get(merged.size() - 1)[1]) {
                merged.add(new int[]{L, intervals[i][1]});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], intervals[i][1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
