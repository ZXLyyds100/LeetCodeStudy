package com.zxl.LeetCode.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class solveNQueens {
    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        List<List<String>> result = new ArrayList<>();
        boolean[] col = new boolean[n];
        boolean[] dg = new boolean[2 * n - 1];
        boolean[] udg = new boolean[2 * n - 1];
        dfs(0, n, board, result, col, dg, udg);
        return result;
    }
    public void dfs (int depth, int n, char[][] board, List<List<String>> result, boolean[] col, boolean[] dg, boolean[] udg) {
        if (depth == n) {
            List<String> item = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                item.add(new String(board[i]));
            }
            result.add(item);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dg[depth + i] && !udg[depth - i + n - 1]) {
                col[i] = true;
                dg[depth + i] = true;
                udg[depth - i + n - 1] = true;
                board[depth][i] = 'Q';
                dfs(depth + 1, n, board, result, col, dg, udg);
                board[depth][i] = '.';
                col[i] = false;
                dg[depth + i] = false;
                udg[depth - i + n - 1] = false;
            }
        }
    }
}
