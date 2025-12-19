package com.zxl.LeetCode.Solution;

public class lowestCommonAncestor {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        dfs(root, p, q);
        return ans;
    }
    public boolean dfs (TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean isCurrentNode = (root == p || root == q);
        boolean leftContains = dfs(root.left, p, q);
        boolean rightContains = dfs(root.right, p, q);
        if ((leftContains && rightContains) || (isCurrentNode && (rightContains || leftContains))) {
            ans = root;
        }
        return leftContains || rightContains || isCurrentNode;
    }


}
