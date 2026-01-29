package com.zxl.LeetCode.Solution;

import java.util.*;

public class topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        int n = nums.length;
        for (Map.Entry<Integer, Integer> cnt : mp.entrySet()) {
            int value = cnt.getKey();
            int count = cnt.getValue();
            if (priorityQueue.size() == k) {
                int[] top = priorityQueue.peek();
                if (top[1] < count) {
                    priorityQueue.poll();
                    priorityQueue.offer(new int[]{value, count});
                }
            } else {
                priorityQueue.offer(new int[]{value, count});
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = priorityQueue.poll()[0];
        }
        return ans;
    }
}