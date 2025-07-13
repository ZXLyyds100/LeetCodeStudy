package com.zxl.LeetCode.Solution;

public class maxArea {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
    public static int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int MaxArea=0;
        while(left<right){
            int area=Math.min(height[left],height[right])*(right-left);
            MaxArea=Math.max(MaxArea,area);
            if(height[left]>=height[right]){
                right--;
            }else{
                left++;
            }
        }
        return MaxArea;
    }
}
