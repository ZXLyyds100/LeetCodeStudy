package com.zxl.LeetCode.Solution;

public class searchMatrix1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = searchCol(matrix, target);
        if(col < 0){
            return false;
        }
        return searchRow(matrix, target, col);
    }
    public int searchCol(int[][] matrix, int target){
        int ans = -1;
        int left = 0, right = matrix.length - 1;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(matrix[mid][0] <= target){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }
    public boolean searchRow(int[][] matrix, int target, int col){
        int left = 0, right = matrix[col].length - 1;
        while(left <= right){
            int mid = (right - left) / 2 +left;
            if(matrix[col][mid] == target){
                return true;
            }else if(matrix[col][mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }

}
