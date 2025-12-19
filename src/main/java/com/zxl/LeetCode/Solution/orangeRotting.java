package com.zxl.LeetCode.Solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class orangeRotting {
    public int orangesRotting(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> time = new HashMap<>();
        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, 1, -1};
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == 2) {
                    int code = i * nc + j;
                    q.add(code);
                    time.put(code, 0);
                }
            }
        }
        int ans = 0;
        while (!q.isEmpty()) {
            int code = q.remove();
            int r = code / nc;
            int c = code % nc;
            for (int i = 0; i < 4; i++) {
                int r1 = r + dr[i];
                int c1 = c + dc[i];
                if (r1 >= 0 && c1 >= 0 && r1 < nr && c1 < nc && grid[r1][c1] == 1) {
                    grid[r1][c1] = 2;
                    int newCode = r1 * nc + c1;
                    q.add(newCode);
                    int newTime = time.get(code) + 1;
                    time.put(newCode, newTime);
                    ans = newTime;
                }
            }
        }
        for (int[] e : grid) {
            for (int a : e) {
                if (a == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }
}
