package com.dml.hw.hsbc;

import java.util.*;

public class SameType {

    public static void main(String[] args) {

        List<String[]> test = new ArrayList<>();
        test.add(new String[]{"egg", "add","true"});
        test.add(new String[]{"foo", "bar", "false"});
        test.add(new String[]{"paper", "title", "true"});
        test.add(new String[]{"abc", "acc", "false"});

        for (String[] arr : test) {
//           System.out.println(sameType(arr[0], arr[1]));
            System.out.println(isIsomorphic(arr[0], arr[1]));
        }
    }

    public static boolean sameType(String s, String t) {

        Map<Character, Character> mappingS = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (int i=0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (null != mappingS.get(sChar)) {
                if (tChar != mappingS.get(sChar)) {
                    return false;
                }
            } else if (set.contains(tChar)) {
                return false;
            } else {
                mappingS.put(s.charAt(i), t.charAt(i));
                set.add(tChar);
            }
        }
        return true;
    }


    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapping = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (null != mapping.get(sChar)) {
                if (tChar != mapping.get(sChar)) {
                    return false;
                }
            } else if (set.contains(tChar)) {
                return false;
            } else {
                mapping.put(sChar, tChar);
                set.add(tChar);
            }
        }
        return true;
    }
}
