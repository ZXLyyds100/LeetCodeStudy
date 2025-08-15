package com.zxl.LeetCode.Solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class orangeRotting {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid[0].length == 0){
            return 0;
        }
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};
        int nr = grid.length;
        int nc = grid[0].length;
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> time = new HashMap<>();
        for(int i = 0; i < nr; i++){
            for(int j = 0; j < nc; j++){
                if(grid[i][j] == 2){
                    q.add(i * nc + j);
                    time.put(i * nc + j, 0);
                }
            }
        }
        int ans = 0;
        while(!q.isEmpty()){
            int code = q.remove();
            int r = code / nc;
            int c = code % nc;
            for(int k = 0; k < 4; k++){
                int r1 = r + dr[k];
                int c1 = c + dc[k];
                if(r1 >= 0 && c1 >= 0 && r1 < nr && c1 < nc && grid[r1][c1] == 1){
                    grid[r1][c1] = 2;
                    q.add(r1 * nc + c1);
                    time.put(r1 * nc + c1, time.get(r * nc + c) + 1);
                    ans =  time.get(r1 * nc + c1);
                }
            }
        }
        for(int[] row : grid){
            for(int e : row){
                if(e == 1){
                    return -1;
                }
            }
        }
        return ans;
    }
}
