package com.zxl.LeetCode.Solution;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class flatten {
    /*List<TreeNode>list=new ArrayList<>();
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        preOrder(root);
        int size=list.size();
        for(int i=1;i<size;i++){
            TreeNode prev=list.get(i-1),cur=list.get(i);
            prev.left=null;
            prev.right=cur;
        }
    }
    public void preOrder(TreeNode root){
        if(root!=null){
            list.add(root);
            preOrder(root.left);
            preOrder(root.right);
        }
    }*/
   /* public void flatten(TreeNode root) {
        List<TreeNode>list=new ArrayList<>();
        Deque<TreeNode>stack=new LinkedList<>();
        TreeNode node=root;
        while(node!=null||!stack.isEmpty()){
            while(node!=null){
                list.add(node);
                stack.push(node);
                node=node.left;
            }
            node=stack.pop();
            node=node.right;
        }
        int size=list.size();
        for(int i=1;i<size;i++){
            TreeNode prev=list.get(i-1),cur=list.get(i);
            prev.left=null;
            prev.right=cur;
        }
    }*/
   /* public void flatten(TreeNode root) {
       if(root==null){
           return;
       }
       Deque<TreeNode>stack=new LinkedList<>();
       stack.push(root);
       TreeNode prev=null;
       while(!stack.isEmpty()){
           TreeNode cur=stack.pop();
           if(prev!=null){
               prev.left=null;
               prev.right=cur;
           }
           if(cur.right!=null){
               stack.push(cur.right);
           }
           if(cur.left!=null){
               stack.push(cur.left);
           }
           prev=cur;
       }
    }*/
    public void flatten(TreeNode root) {
        if(root==null)return;
        TreeNode cur=root;
        while(cur!=null){
            if(cur.left!=null){
                TreeNode next=cur.left;
                TreeNode p=next;
                while(p.right!=null){
                    p=p.right;
                }
                p.right=cur.right;
                cur.left=null;
                cur.right=next;
            }
            cur=cur.right;
        }
    }
}
