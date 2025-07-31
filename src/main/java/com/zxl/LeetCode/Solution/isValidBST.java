package com.zxl.LeetCode.Solution;

public class isValidBST {
    public boolean isValidBST(TreeNode root) {
        return solve(root,Long.MIN_VALUE,Long.MIN_VALUE);
    }
    public boolean solve(TreeNode root,long lower,long upper){
        if(root==null){
            return true;
        }
        if(root.val<=lower||root.val>=upper){
            return false;
        }
        return solve(root.left,lower,root.val)&&solve(root.right,root.val,upper);
    }
}
