package com.zxl.LeetCode.Solution;

import java.util.LinkedList;
import java.util.Queue;

public class numIsland_bfs {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int cnt = 0;
        for(int i = 0; i < nr; i++){
            for(int j = 0; j < nc; j++){
                if(grid[i][j] == '1'){
                    ++cnt;
                    Queue<Integer> q = new LinkedList<>();
                    q.add(i * nc + j);
                    while(!q.isEmpty()){
                        int now = q.remove();
                        int r1 = now / nc;
                        int c1 = now % nc;
                        grid[r1][c1] = '0';
                        if(r1 -1 >= 0&& grid[r1 - 1][c1] == '1'){
                            q.add((r1 - 1) * nc + c1);
                            grid[r1 - 1][c1] = '0';
                        }
                        if(r1 + 1 < nr && grid[r1 + 1][c1] == '1'){
                            q.add((r1 + 1) * nc + c1);
                            grid[r1 + 1][c1] = '0';
                        }
                        if(c1 - 1 >= 0 && grid[r1][c1 - 1] == '1'){
                            q.add(r1 * nc + c1 - 1);
                            grid[r1][c1 - 1] = '0';
                        }
                        if(c1 + 1 < nc && grid[r1][c1 + 1] == '1'){
                            q.add(r1 * nc + c1 + 1);
                            grid[r1][c1 + 1] = '0';
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
