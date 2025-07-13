package com.zxl.LeetCode.Solution;

public class trapByDoubleIndex {
    public int trap(int[] height) {
        int ans=0;
        int n=height.length;
        int left=0,right=n-1;
        int leftMax=0,rightMax=0;
        while(left<right){
          /*  leftMax=Math.max(height[left],leftMax);
            rightMax=Math.max(height[right],rightMax);
            if(height[left]>height[right]){
                ans+=
            }*/
            if(height[left]<height[right]){// 简单说就是如果此时右边界比左大说明左边是可以积水的，想反，右小于左，说明左边是可以积水的，
                // 很简单的思路，如果此时有最比leftMax大的数就更新leftMax，否则就直接计算加水值，如果left++后，不再小于right的height了，就更换
                if(height[left]>=leftMax){
                    leftMax=height[left];
                }else{
                    ans+=leftMax-height[left];
                }
                left++;
            }else{
                if(height[right]>=rightMax){
                    rightMax=height[right];
                }else{
                    ans+=rightMax-height[right];
                }
                right--;
            }
        }
        return ans;
    }
}
