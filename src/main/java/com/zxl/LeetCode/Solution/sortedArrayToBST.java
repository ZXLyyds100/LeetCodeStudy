package com.zxl.LeetCode.Solution;


public class sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return solve(nums,0,nums.length-1);
    }
    public TreeNode solve(int[] nums,int left,int right){
        if (left > right) {
            return null;
        }
        int mid =(left + right) >> 1;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = solve(nums, left, mid - 1);
        node.right = solve(nums, mid + 1, right);
        return node;
    }
}
