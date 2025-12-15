package com.zxl.LeetCode.Solution;

import java.util.HashMap;
import java.util.Map;

public class buildTree {
    /*Map<Integer,Integer>mp;
    public TreeNode myBuildTree(int[] preOrder, int[] inOrder,
                                int preBegin, int preEnd,
                                int orderBegin, int OrderEnd){
        if(preBegin>preEnd){
            return null;
        }
        int rootValue = preOrder[preBegin];
        int orderRootIndex = mp.get(rootValue);
        int leftSize = orderRootIndex - orderBegin;
        TreeNode root = new TreeNode(preOrder[preBegin]);
        root.left = myBuildTree(preOrder, inOrder, preBegin+1, preBegin+leftSize, orderBegin, orderRootIndex-1);
        root.right = myBuildTree(preOrder, inOrder, preBegin+leftSize+1, preEnd, orderRootIndex+1, OrderEnd);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        mp = new HashMap<>();
        for(int i = 0; i < inorder.length;i++){
            mp.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, preorder.length-1,0, inorder.length-1);
    }*/










    Map<Integer, Integer> inorderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode build(int[] preOrder, int preBegin, int preEnd,
                          int[] inOrder, int inBegin, int inEnd) {
        if (preBegin > preEnd) {
            return null;
        }
        int val = preOrder[preBegin];
        Integer index = inorderIndex.get(val);
        int leftSize = index - inBegin;
        TreeNode root = new TreeNode(val);
        root.left = build(preOrder, preBegin + 1, preBegin + leftSize, inOrder, inBegin, index - 1);
        root.right = build(preOrder, preBegin + leftSize + 1, preEnd, inOrder, index + 1, inEnd);
        return root;

    }





















}
