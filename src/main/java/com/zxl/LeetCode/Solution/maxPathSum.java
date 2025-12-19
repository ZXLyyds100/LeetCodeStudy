package com.zxl.LeetCode.Solution;

public class maxPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMaxSum(root);
        return maxSum;
    }
    public int getMaxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = Math.max(getMaxSum(root.left), 0);
        int rightSum = Math.max(getMaxSum(root.right), 0);
        maxSum = Math.max(maxSum, leftSum + rightSum + root.val);
        return root.val + Math.max(leftSum, rightSum);
    }

}
