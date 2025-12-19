package com.zxl.LeetCode.Solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class canFinish {
    int[] e;
    int[] d;
    int[] ne;
    int[] h;
    int idx = 0;
    public void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    int n, m;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        n = numCourses;
        m = prerequisites.length;
        e = new int[m];
        ne = new int[m];
        h = new int[n];
        d = new int[n];
        Arrays.fill(h, -1);
        for (int[] edge : prerequisites) {
            int a = edge[0];
            int b = edge[1];
            add(b, a);
            d[a]++;
        }
        return topsort();
    }
    public boolean topsort(){
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (d[i] == 0) {
                q.offer(i);
                cnt++;
            }
        }
        while (!q.isEmpty()) {
            int k = q.poll();
            for (int i = h[k]; i != -1; i = ne[i]) {
                int j = e[i];
                d[j]--;
                if (d[j] == 0) {
                    cnt++;
                    q.offer(j);
                }
            }
        }
        return cnt == n;
    }
}
