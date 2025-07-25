package com.zxl.LeetCode.Solution;

public class isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        check(root.left,root.right);
    }
    public boolean check(TreeNode left,TreeNode right){
        if(right==null&&left==null){
            return true;
        }
        if(right==null||left==null){
            return false;
        }
        return right.val==left.val&&check(left.left,right.right)&&check(left.right,right.left);
    }
}
