package com.zxl.LeetCode.Solution;


import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class maxDepth {
    public int maxDepth(TreeNode root) {
     /*   if(root==null){
            return 0;
        }
        int L=maxDepth(root.left);
        int R=maxDepth(root.right);
        return Math.max(L,R)+1;*/
        /*if(root==null){
            return 0;
        }
        Queue<TreeNode>q=new LinkedList<>();
        int ans=0;
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            while(size>0){
                TreeNode node=q.poll();
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;*/
        if (root == null) {
            return 0;
        }
        int L = maxDepth(root.left);
        int R = maxDepth(root.right);
        return Math.max(L, R) + 1;
    }
}
