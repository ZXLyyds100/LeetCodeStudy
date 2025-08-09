package com.zxl.LeetCode.Solution;

public class lowestCommonAncestor {
   /* TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        dfs(root, p, q);
        return ans;
    }
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)return false;
        boolean l = dfs(root.left, p, q);
        boolean r = dfs(root.right, p, q);
        if((l && r)||((root.val == p.val)||(root.val == q.val) && (l || r))){
            ans = root;
        }
        return l || r || ((root.val == p.val) || (root.val == q.val));
    }*/

}
