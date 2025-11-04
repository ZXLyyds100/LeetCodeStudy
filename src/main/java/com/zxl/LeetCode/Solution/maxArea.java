package com.zxl.LeetCode.Solution;

public class maxArea {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
    public static int maxArea(int[] height) {
       int left = 0, right = height.length - 1;
       int maxArea = 0;
       for (int i = 0; i < height.length; i++) {
           int area = Math.min(height[left], height[right]) * (right - left);
           maxArea = Math.max(area, maxArea);
           if (height[left] >= height[right]) {
               right--;
           } else {
               left++;
           }
       }
       return maxArea;
    }
}
