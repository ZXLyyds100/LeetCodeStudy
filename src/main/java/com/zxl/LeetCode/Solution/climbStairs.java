package com.zxl.LeetCode.Solution;

public class climbStairs {
    public int climbStairs(int n) {
        int f0 = 0;// f-1，第-1没有方案
        int f1 = 0;// f0，有一种
        int fn = 1;// f1，有一种
        for (int i = 0; i < n; i++) {
            f0 = f1;
            f1 = fn;
            fn = f1 + f0;
        }
        return fn;
    }
}
