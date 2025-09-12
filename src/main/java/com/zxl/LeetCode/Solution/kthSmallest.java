package com.zxl.LeetCode.Solution;

import java.util.Deque;
import java.util.LinkedList;

public class kthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            k--;
            root = stack.pop();
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}
