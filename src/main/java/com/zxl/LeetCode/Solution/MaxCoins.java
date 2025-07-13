package com.zxl.LeetCode.Solution;
// https://leetcode.cn/problems/burst-balloons/description/

import java.util.ArrayList;
import java.util.List;

/*
*
有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。

现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。

求所能获得硬币的最大数量。



示例 1：
输入：nums = [3,1,5,8]
输出：167
解释：
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
示例 2：

输入：nums = [1,5]
输出：10


提示：

n == nums.length
1 <= n <= 300
0 <= nums[i] <= 100*/
public class MaxCoins {
    public int maxCoins(int[] nums) {
        int[][] dp=new int[310][310];// dp[i][j]是戳破(i,j)之间的气球获得的最大金币数
        List<Integer>Nums=new ArrayList<>();
        Nums.add(1);
        for(int e:nums){
            Nums.add(e);
        }
        Nums.add(1);//前后填1
        int n=Nums.size()-2;
        for(int len=1;len<=n;len++){
            for(int i=1;i+len-1<=n;i++){
                int j=i+len-1;
                for(int k=i;k<=j;k++){
                    dp[i][j]=Math.max(dp[i][j],dp[i][k-1]+dp[k+1][j]+ Nums.get(k) *Nums.get(i-1)*Nums.get(j+1));
                    // k是最后一个戳破的气球，把[i,k-1]和[k+1,j]的最大金币数加上当前位置的最大金币数
                }
            }
        }
        return dp[1][n];
    }

}
