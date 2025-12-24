package com.zxl.LeetCode.Solution;

import java.util.ArrayList;
import java.util.List;

public class subsets {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums.length, 0, nums);
        return ans;
    }
    private void dfs (int n, int depth, int[] nums) {
        if (depth == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[depth]);
        dfs(n, depth + 1, nums);
        temp.remove(temp.size() - 1);
        dfs(n, depth + 1, nums);
    }
   /* List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        for(int mark = 0;mark<(1<<n);mark++){
            temp.clear();
            for(int i = 0;i < n;i++){
                if((mark&(1<<i))!=0)temp.add(nums[i]);
            }
            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }*/
}
