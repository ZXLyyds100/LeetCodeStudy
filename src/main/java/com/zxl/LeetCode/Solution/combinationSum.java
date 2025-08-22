package com.zxl.LeetCode.Solution;

import java.util.ArrayList;
import java.util.List;

public class combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        dfs(ans, item, 0, 0, target, candidates);
        return ans;
    }
    public void dfs(List<List<Integer>> ans, List<Integer> item, int index, int sum, int target, int[] candidates){
        if(sum >= target){
            if(sum == target){
                ans.add(new ArrayList<>(item));
            }
            return;
        }
        for(int i = index; i < candidates.length; i++){
            item.add(candidates[i]);
            dfs(ans, item, i, sum + candidates[i], target, candidates);
            item.remove(item.size() - 1);
        }
    }
}
