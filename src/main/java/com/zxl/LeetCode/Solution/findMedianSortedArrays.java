package com.zxl.LeetCode.Solution;

public class findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int n = length2 + length1;
        if (n % 2 == 1) {
            return getKthElement(nums1, nums2, n / 2 + 1);
        } else {
            return (getKthElement(nums1, nums2, n / 2) + getKthElement(nums1, nums2, n / 2 + 1)) / 2.0;
        }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int index1 = 0, index2 = 0;
        while(true) {
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            } else if (index2 == length2) {
                return nums1[index1 + k - 1];
            } else if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            int newIndex1 = Math.min(length1, index1 + k / 2) - 1;
            int newIndex2 = Math.min(length2, index2 + k / 2) - 1;
            int val1 = nums1[newIndex1];
            int val2 = nums2[newIndex2];
            if (val1 <= val2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }

        }
    }
}
