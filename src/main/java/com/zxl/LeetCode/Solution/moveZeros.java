package com.zxl.LeetCode.Solution;

public class moveZeros {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        int n = nums.length;
      /*  while(right<n){
            if(nums[right]!=0){
                swap(nums,left,right);
                left++;
            }
            right++;
        }*/
        //left是当前可以放置非0元素的地方，而right是用来搜索非0元素，然后放置到left上
        //当left和right初始的都不是0，都++右移，然后遇到0，右指针右移动，然后左指针等待右指针找到非0元素然后交换
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                if (i != left) {
                    swap(nums, left, right);
                }
                left++;
            }

        }

    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
