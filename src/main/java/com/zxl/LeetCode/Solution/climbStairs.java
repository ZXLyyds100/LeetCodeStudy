package com.zxl.LeetCode.Solution;

public class climbStairs {
    public int climbStairs(int n) {
        int f1, f2, fn;
        f1 = 0;
        f2 = 0;
        fn = 1;// 初始为n为1
        for(int i = 0; i < n; i++){
            f1 = f2;
            f2 = fn;
            fn = f1 + f2;
        }
        return fn;
    }
}
