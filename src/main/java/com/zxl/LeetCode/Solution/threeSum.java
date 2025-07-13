package com.zxl.LeetCode.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        int first=0;
        Arrays.sort(nums);
        List<List<Integer>>ans=new ArrayList<>();
        for(first=0;first<=n-1;first++){
            if(first>0&&nums[first]==nums[first-1]){
                continue;
            }
            int third=n-1;
            int target=-nums[first];
            for(int second=first+1;second<third;second++){
                if(second>first+1&&nums[second-1]==nums[second]){
                    continue;
                }
                while(second<third&&nums[second]+nums[third]>target){
                    third--;
                }
                if(second==third)break;
                if(nums[second]+nums[third]==target){
                    List<Integer>list=new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }   
}
