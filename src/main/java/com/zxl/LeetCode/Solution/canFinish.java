package com.zxl.LeetCode.Solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class canFinish {
    int[] d;
    int[] e;
    int[] ne;
    int[] h;
    int idx = 0;
    int n;
    public void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int m = prerequisites.length;
        n = numCourses;
        d = new int[n];
        h = new int[n];
        e = new int[m];
        ne = new int[m];
        Arrays.fill(h, -1);
        for(int[] edge : prerequisites){
            int a = edge[0], b = edge[1];
            add(b, a);
            d[a]++;
        }
        return topsort();
    }
    public boolean topsort(){
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(d[i] == 0){
                cnt++;
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int t = q.poll();
            for(int i = h[t]; i != -1; i = ne[i]){
                int j = e[i];
                d[j]--;
                if(d[j] == 0){
                    q.offer(j);
                    cnt++;
                }
            }
        }
        return cnt == n;
    }
}
