package com.zxl.LeetCode.Solution;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class pathSum {

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs(prefix, 0L, targetSum, root);
    }
    public int dfs(Map<Long, Integer> prefix, Long curr, int targetSum, TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        curr += root.val;
        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(prefix, curr, targetSum, root.left);
        ret += dfs(prefix, curr, targetSum, root.right);
        prefix.put(curr, prefix.get(curr) - 1);
        return ret;
    }


}
