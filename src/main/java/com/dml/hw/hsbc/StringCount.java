package com.dml.hw.hsbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringCount {

    public static void main(String[] args) {
        List<String[]> test = new ArrayList<>();
        test.add(new String[]{"00010011", "9"});
        test.add(new String[]{"010010", "5"});
        test.add(new String[]{"0100100", "7"});
        test.add(new String[]{"1100100", "6"});
        test.add(new String[]{"11001001", "6"});

        for(String[] str : test) {
            System.out.println(stringCount(str[0]));
        }

    }

    public static int stringCount(String str) {
        int result = 0;
        int j = -1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            boolean next = true;

            if (c == '0') {
                if (j < 0) {
                    j = i;
                }
                if (i == str.length() - 1) {
                    i++;
                    next = false;
                }
            } else {
                next = false;
            }

            if (next) {
                continue;
            }

            if (j >= 0) {
                int num = i -j;
                int add = ((num + 1) * num)/2;
                result += add;
                j = -1;
            }
        }
        return result;
    }
}
