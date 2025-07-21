package com.zxl.LeetCode.Main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

// String
public class Main {
    public static void main(String[] args) {
        String dateStr = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String uuid = UUID.randomUUID().toString();
        String code = dateStr + "-" + uuid + "-2";
        System.out.println(code);
    }
}
