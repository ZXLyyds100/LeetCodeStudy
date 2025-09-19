package com.zxl.LeetCode.Solution;

public class majorityElement {
    public int majorityElement(int[] nums) {
        // 既然题目已经保证了一定会出现众数，也就是出现频率超过数量的一半，那么把这个数之外的数都当作反对者
        // 这个数当作支持者，一个-1一个+1，最后>0那个就是众数
        int count = 0;
        Integer majority = null;
        for (int num : nums) {
            if (count == 0) {
                majority = num;
            }
            count += (num == majority) ? 1 : -1;
        }
        return majority;
    }
}
