package com.zxl.LeetCode.Solution;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class isValidBrackets {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        HashMap<Character, Character> mp = new HashMap<>();
        mp.put(')', '(');
        mp.put('}', '{');
        mp.put(']', '[');
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (mp.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != mp.get(ch)) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
