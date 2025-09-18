package com.zxl.LeetCode.Solution;

public class findDuplicate {
    public int findDuplicate(int[] nums) {
   /*     int n = nums.length;
        int l = 0, r = n - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + r >> 1;
            int cnt = 0;
            for (int i = 0; i <= n - 1; i++) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;*/
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
