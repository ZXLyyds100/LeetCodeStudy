package com.zxl.LeetCode.Solution;

public class searchLoopArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0){
            return -1;
        }
        if(n == 1){
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while(l <= r){
            int mid = (r - l) / 2 + l;
            if(nums[mid] == target){
                return mid;
            }
            // 因为左右至少一个半区是有序的，所有先判断哪一边有序，然后看是否在有序那边
            if(nums[0] <= nums[mid]){
                //判断是否在有序的左半边
                if(nums[0] <= target && target < nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            } else{
                if(nums[mid] < target && target <= nums[n - 1]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
