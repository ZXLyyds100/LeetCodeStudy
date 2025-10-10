package com.zxl.LeetCode.Solution;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(new char[2 * n], 0, ans, n);
        return ans;
    }
    public void dfs(char[] current, int pos, List<String> ans, int n) {
        if (pos == 2 * n) {
            if (isValid(current)) {
                ans.add(new String(current));
            }

        } else {
            current[pos] = '(';
            dfs(current, pos + 1, ans, n);
            current[pos] = ')';
            dfs(current, pos + 1, ans, n);
        }
    }
    public boolean isValid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
}
