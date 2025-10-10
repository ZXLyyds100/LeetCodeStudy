package com.zxl.LeetCode.Solution;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(0, 0, ans, n, new StringBuilder());
        return ans;
    }
    public void dfs(int open, int close, List<String> ans, int n, StringBuilder current) {
        if (current.length() == 2 * n) {
            if (isValid(current)) {
                ans.add(new String(current));
            }

        } else {
            if (open < n) {
                current.append('(');
                dfs(open + 1, close, ans, n, current);
                current.deleteCharAt(current.length() - 1);
            }
            if (close < n) {
                current.append(')');
                dfs(open, close + 1, ans, n, current);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }
    public boolean isValid(StringBuilder current) {
        int balance = 0;
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) == '(') {
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
