package com.zxl.LeetCode.Solution;

public class jump {
    public int jump_1(int[] nums) {
        int pos = nums.length - 1;
        int steps = 0;
        while(pos > 0){
            for(int i = 0; i < pos; i++){
                if(pos <= i + nums[i]){
                    steps++;
                    pos = i;
                    break;
                }
            }
        }
        return steps;
    }
    public int jump_2(int[] nums){
            int maxPosition = 0;
            int end = 0;
            int length = nums.length;
            int steps = 0;
            for(int i = 0; i < length - 1; i++){
                maxPosition = Math.max(maxPosition, i + nums[i]);
                if(i == end){
                    end = maxPosition;
                    steps++;
                }
            }
            return steps;
    }
}
