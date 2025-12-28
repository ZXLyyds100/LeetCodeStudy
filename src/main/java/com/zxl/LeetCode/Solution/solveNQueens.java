package com.zxl.LeetCode.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class solveNQueens {
    boolean[] col;
    boolean[] udg;
    boolean[] dg;
    char[][] board;
    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        col = new boolean[n];
        dg = new boolean[2 * n - 1];
        udg = new boolean[2 * n - 1];
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        List<List<String>> ans = new ArrayList<>();
        dfs(0, n, ans);
        return ans;
    }
    public void dfs(int depth, int n, List<List<String>> ans) {
        if (depth == n) {
            List<String> item = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                item.add(new String(board[i]));
            }
            ans.add(item);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dg[depth + i] && !udg[depth - i + n - 1]) {
                col[i] = true;
                dg[depth + i] = true;
                udg[depth - i + n - 1] = true;
                board[depth][i] = 'Q';
                dfs(depth + 1, n , ans);
                col[i] = false;
                dg[i + depth] = false;
                udg[depth - i + n - 1] = false;
                board[depth][i] = '.';
            }
        }
    }

}
