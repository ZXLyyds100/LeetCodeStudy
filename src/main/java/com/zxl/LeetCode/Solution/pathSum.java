package com.zxl.LeetCode.Solution;

import java.util.HashMap;
import java.util.Map;

public class pathSum {
    /*public int pathSum(TreeNode root, int targetSum) {
        if(root == null)return 0;
        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);z
        ret += pathSum(root.right, targetSum);
        return ret;
    }
    public int rootSum(TreeNode root, int targetSum){
        if(root == null){
            return 0;
        }
        int ret = 0;
        int val = root.val;
        if(val == targetSum){
            ret++;
        }
        ret += rootSum(root.left, targetSum-val);
        ret += rootSum(root.right, targetSum-val);
        return ret;
    }*/
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer>mp = new HashMap<>();
        mp.put(0L, 1);
        return dfs(root, mp, 0, targetSum);
    }
    public int dfs(TreeNode root, Map<Long, Integer>prefix, long curr, int targetSum){
        if(root == null){
            return 0;
        }
        int ret = 0;
        curr += root.val;// curr + A = targetSum，看集合里面有没有
        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.get(curr) - 1);
        return ret;
    }

}
