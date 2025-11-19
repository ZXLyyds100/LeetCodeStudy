package com.zxl.LeetCode.Solution;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int total = row * col;
        if (row <= 0 || col <= 0 || matrix == null) {
            return new ArrayList<>();
        }
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int next = 0;
        List<Integer> ans = new ArrayList<>();
        boolean[][] visited = new boolean[row][col];
        int r = 0, c = 0;
        for (int i = 0; i < total; i++) {
            ans.add(matrix[r][c]);
            visited[r][c] = true;
            int r1 = r + dir[next][0];
            int c1 = c + dir[next][1];
            if (r1 < 0 || c1 < 0 || r1 >= row || c1 >= col || visited[r1][c1]) {
                next = (next + 1) % 4;
            }
            r = r + dir[next][0];
            c = c + dir[next][1];
        }
        return ans;
    }
}
