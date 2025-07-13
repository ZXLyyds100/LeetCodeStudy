package com.zxl.LeetCode.Solution;

import java.util.*;
import java.util.stream.IntStream;

public class SlideWindow {
    public static void main(String[] args) {
        int []nums=new int[]{1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums,3)));
    }
/*    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer>q=new ArrayDeque<>();
        int []ans=new int[n-k+1];
        int idx=0;
        for(int i=0;i<n;i++){
            while(!q.isEmpty()&&q.peekFirst()<=i-k){
                q.pollFirst();
            }
            while(!q.isEmpty()&&nums[q.peekLast()]<=nums[i]){
                q.pollLast();
            }
            q.addLast(i);
            if(i>=k-1){
                ans[idx++]=nums[q.peekFirst()];
            }
        }
        return ans;
    }*/
   public static int[] maxSlidingWindow(int[] nums, int k) {
       int n=nums.length;
       int []prefixMax=new int[n];
       int []suffixMax=new int[n];
       for(int i=0;i<n;i++){
           if(i%k==0){
               prefixMax[i]=nums[i];
           }else{
               prefixMax[i]=Math.max(prefixMax[i-1],nums[i]);
           }
       }
       for(int i=n-1;i>=0;i--){
           if(i==n-1||(i+1)%k==0){//如果是末尾或者新的分组的末尾
               suffixMax[i]=nums[i];
           }else{
               suffixMax[i]=Math.max(suffixMax[i+1],nums[i]);
           }
       }
       int[]ans=new int[n-k+1];
       for(int i=0;i<=n-k;i++){
           ans[i]=Math.max(suffixMax[i],prefixMax[i+k-1]);
       }
       return ans;
   }
}
