package com.dml.hw.datastructure.linked;

import java.util.LinkedList;

/**
 * @author Louis
 * @version 1.0
 * @since 2019/11/7
 */
public class TestLinked {


    public static void main(String[] args) {

        test_1();
    }


    public static void test() {

        LinkedList<String> list = new LinkedList<>();


    }


    public static void test_1() {

        HwLinkedList_1<String> list = new HwLinkedList_1();

        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }

        list.add(5, "5");

        System.out.println(list.toString());

        list.reversal();

        System.out.println(list.toString());
    }
}
