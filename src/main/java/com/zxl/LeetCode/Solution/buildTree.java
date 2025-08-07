package com.zxl.LeetCode.Solution;

import java.util.HashMap;
import java.util.Map;

public class buildTree {
    Map<Integer,Integer>mp;
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
    }
}
