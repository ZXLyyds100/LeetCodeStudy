package com.zxl.LeetCode.Solution;

import java.util.Deque;
import java.util.LinkedList;

public class trapByMonoStack {
    public int trap(int[] height) {
        int ans=0;
        int n=height.length;
        Deque<Integer>stack=new LinkedList<>();
        for(int i=0;i<n;i++){
            while(!(stack.isEmpty())&&height[stack.peek()]<height[i]){//原本保持单调递减，如果有元素比栈顶大说明形成水泽。
                int top=stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int left=stack.peek();
                int currentWidth=i-left-1;
                int currentHeight=Math.min(height[i],height[left])-height[top];
                ans+=currentHeight*currentWidth;
            }
            stack.push(i);
        }
        return ans;
    }
}
