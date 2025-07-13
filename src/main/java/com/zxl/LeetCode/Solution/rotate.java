package com.zxl.LeetCode.Solution;

public class rotate {
   /* public void rotate(int[] nums, int k) {
        int n=nums.length;
        int[]newArr=new int[n];
        for(int i=0;i<n;i++){
            newArr[(i+k)%n]=nums[i];
        }
        System.arraycopy(newArr,0,nums,0,n);
    }*/
   public void rotate(int[] nums, int k) {
       int n=nums.length;
       k=k%n;
       // 就是隔位的值的轮换，这样就不会使得值被意外覆盖
       // gcd用欧几里得
       int count=gcd(n,k);
       for(int i=0;i<count;i++){
           int cur=i;
           int preValue=nums[i];
           do{
               int next=(cur+k)%n;
               int temp=nums[next];
               nums[next]=preValue;
               preValue=temp;
               cur=next;
           }while(cur!=i);
       }
   }
   public int gcd(int x,int y){
       return y>0?gcd(y,x%y):x;
   }
}
