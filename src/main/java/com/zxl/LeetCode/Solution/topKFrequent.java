package com.zxl.LeetCode.Solution;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (Map.Entry<Integer, Integer> cnt : count.entrySet()) {
            int num = cnt.getKey();
            int cnt1 = cnt.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < cnt1) {
                    queue.poll();
                    queue.offer(new int[]{num, cnt1});
                }
            } else {
                queue.offer(new int[]{num, cnt1});
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
}