package com.zxl.LeetCode.Solution;

public class numIsland_dfs {
    int nr;
    int nc;
    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        nr = grid.length;
        nc = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }
    public void dfs(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}
