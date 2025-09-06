package com.zxl.LeetCode.Solution;

public class matrixExitWord {
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j]){
                    if(dfs(visited, i, j, 0, board, word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(boolean[][] visited, int x, int y, int k, char[][] board, String word){
        if(board[x][y] != word.charAt(k)){
            return false;
        }
        if(k == word.length() - 1){
            return true;
        }
        visited[x][y] = true;
        boolean result = false;
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        for(int i = 0; i < 4; i++){
            int x1 = x + dx[i];
            int y1 = y + dy[i];
            if(x1 >=0 && y1 >= 0 && x1 < board.length && y1 < board[0].length){
                if(!visited[x1][y1]){
                    boolean flag = dfs(visited, x1, y1, k + 1, board, word);
                    if(flag){
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[x][y] = false;
        return result;
    }

}
