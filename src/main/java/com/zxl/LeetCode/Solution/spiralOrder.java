package com.zxl.LeetCode.Solution;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        boolean[][]visited=new boolean[row][col];
        if(row<=0||col<=0||matrix==null){
            return new ArrayList<Integer>();
        }
        int total=row*col;
        List<Integer>ans=new ArrayList<>();
        int[][]direction={{0,1},{1,0},{0,-1},{-1,0}};
        int next=0;
        int r=0,c=0;
        for(int i=0;i<total;i++){
            ans.add(matrix[r][c]);
            visited[r][c]=true;
            int r1=r+direction[next][0];
            int c1=c+direction[next][1];
            if(r1<0||c1<0||r1>=row||c1>=col||visited[r1][c1]){
                next=(next+1)%4;
            }
            r=r+direction[next][0];
            c=c+direction[next][1];
        }
        return ans;
    }
}
