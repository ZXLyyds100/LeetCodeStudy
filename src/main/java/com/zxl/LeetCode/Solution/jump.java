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
}
