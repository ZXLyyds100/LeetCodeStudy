package com.zxl.LeetCode.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class partitionString {
    boolean[][] dp;
    List<List<String>> ret;
    List<String> ans;
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        dp = new boolean[n][n];
        ans = new ArrayList<>();
        ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
            }
        }
        dfs(s, 0);
        return ret;
    }
    public void dfs(String s, int depth) {
        if (depth == n) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for (int i = depth; i < n; i++) {
            if (dp[depth][i]) {
                ans.add(s.substring(depth, i + 1));
                dfs(s, i + 1);
                ans.remove(ans.size() - 1);
            }
        }

    }


}
