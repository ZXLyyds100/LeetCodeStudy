package com.zxl.LeetCode.Solution;

import java.util.ArrayList;
import java.util.List;

public class subsets {
  /*  List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        dfs(0, n, nums);
        return ans;
    }
    public void dfs(int depth, int n, int[] nums){
        if(depth == n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[depth]);
        dfs(depth + 1, n, nums);
        temp.remove(temp.size() - 1);
        dfs(depth + 1, n, nums);
    }*/
    List<Integer> temp = new ArrayList<>();
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
    }
}
