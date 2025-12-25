package com.zxl.LeetCode.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letterCombinations {
    public List<String> letterCombinations(String digits) {
        if (digits == null) {
            return new ArrayList<>();
        }
        Map<Character, String> phone = new HashMap<>(){
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        List<String> ans = new ArrayList<>();
        dfs(new StringBuffer(), 0, phone, digits, ans);
        return ans;
    }
    private void dfs(StringBuffer item, int index, Map<Character, String> phone, String digits, List<String> ans) {
        if (item.length() == digits.length()) {
            ans.add(new String(item));
            return;
        }
        Character digit = digits.charAt(index);
        String letters = phone.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            item.append(letters.charAt(i));
            dfs(item, index + 1, phone, digits, ans);
            item.deleteCharAt(item.length() - 1);
        }
    }
}
