package com.zxl.LeetCode.Solution;

public class maxPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGrain(root);
        return maxSum;
    }
    public int maxGrain(TreeNode root){
        if(root == null)return 0;
        int leftGrain = Math.max(maxGrain(root.left), 0);
        int rightGrain = Math.max(maxGrain(root.right), 0);
        int pathSum = root.val + leftGrain + rightGrain;
        maxSum = Math.max(pathSum, maxSum);
        return root.val + Math.max(leftGrain, rightGrain);
    }
}
