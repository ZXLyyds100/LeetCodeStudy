package com.zxl.LeetCode.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0){
            return ans;
        }
        Map<Character, String> phone = new HashMap<>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrace(ans, new StringBuffer(), 0, digits, phone);
        return ans;
    }
    public void backtrace (List<String> ans, StringBuffer item, int index, String digits, Map<Character, String> phone){
        if(item.length() == digits.length()){
            ans.add(item.toString());
        }else{
            char digit = digits.charAt(index);
            String letter = phone.get(digit);
            for(int i = 0; i < letter.length(); i++){
                item.append(letter.charAt(i));
                backtrace(ans, item, index + 1, digits, phone);
                item.deleteCharAt(index);
            }
        }
    }
}
