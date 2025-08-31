package com.zxl.LeetCode.Solution;

public class decodeString {
    String src;
    int ptr;
    public String decodeString(String s) {
        src = s;
        ptr = 0;
        return getString();
    }
    public String getString(){
        if(ptr == src.length() || src.charAt(ptr) == ']'){
            return "";
        }
        int repeat = 1;
        String ret = "";
        char cur = src.charAt(ptr);
        if(Character.isDigit(cur)){
            repeat = getInt();
            ++ptr;
            String str = getString();
            ++ptr;
            while (repeat > 0){
                ret += str;
                repeat --;
            }
        }else if(Character.isLetter(cur)){
            ret += String.valueOf(cur);
            ptr++;
        }
        return ret + getString();
    }
    public int getInt(){
        int ret = 0;
        while(ptr < src.length() && Character.isDigit(src.charAt(ptr))){
            ret = ret * 10 + src.charAt(ptr) - '0';
            ptr ++;
        }
        return ret;
    }
}
