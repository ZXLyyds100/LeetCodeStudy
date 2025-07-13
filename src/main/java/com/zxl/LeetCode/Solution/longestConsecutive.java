package com.zxl.LeetCode.Solution;

import java.util.HashSet;
import java.util.Set;

public class longestConsecutive {
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<Integer>();
            int logest = 0;
            for (int num : nums) {
                set.add(num);
            }
            for (int num : set) {
                if(set.contains((num-1)))continue;
                int current = num;
                int currentLength = 1;
                while (set.contains(current + 1)) {
                    currentLength++;
                    current++;
                }
                logest = Math.max(currentLength, logest);
            }
            return logest;
        }
    }
}
