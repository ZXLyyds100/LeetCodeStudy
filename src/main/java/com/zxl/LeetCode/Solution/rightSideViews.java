package com.zxl.LeetCode.Solution;

import com.sun.source.tree.Tree;

import java.util.*;

public class rightSideViews {
    /*
        List<Integer>ans=new ArrayList<>();
        public List<Integer> rightSideView(TreeNode root) {
            dfs(root,0);
            return ans;
        }
        public void dfs(TreeNode root,int depth){
            if(root==null){
                return;
            }
            if(depth==ans.size()){
                ans.add(root.val);
            }
            depth++;
            dfs(root.right,depth);
            dfs(root.left,depth);
        }
    */
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {
                    ans.add(node.val);
                }
            }
        }
        return ans;
    }

}
