package com.zxl.LeetCode.Solution;

public class searchMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int x = matrix[mid / n][mid % n];
            if (x == target) {
                return true;
            } else if (x < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
