package com.zxl.LeetCode.Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer>ans=new ArrayList<>();
        Queue<TreeNode>q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
                if(i==size-1){
                    ans.add(node.val);
                }
            }
        }
        return ans;
    }

}
