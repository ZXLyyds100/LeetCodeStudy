package com.zxl.LeetCode.Solution;

public class matrixExitWord {
    int n;
    int m;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {

        n = board.length;
        m = board[0].length;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    if (dfs(word, 0, i, j,  board)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(String word, int k, int x, int y, char[][] board) {
        if (board[x][y] != word.charAt(k)) {
            return false;
        }
        if (k == word.length() - 1) {
            return true;
        }
        visited[x][y] = true;
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        boolean result = false;
        for (int i = 0; i < 4; i++) {
            int x1 = x + dx[i];
            int y1 = y + dy[i];
            if (x1 >= 0 && y1 >= 0 && x1 < n && y1 < m && !visited[x1][y1]) {
                if (dfs(word, k + 1, x1, y1, board)) {
                    result = true;
                    break;
                }
            }
        }
        visited[x][y] = false;
        return result;
    }
}
