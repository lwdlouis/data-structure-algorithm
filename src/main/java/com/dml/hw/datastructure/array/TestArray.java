package com.dml.hw.datastructure.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Louis
 * @version 1.0
 * @since 2019/11/5
 */
public class TestArray {



    public static void main(String[] args) {
//        origin();
//        test_1();
        test_2();
    }


    public static void origin() {
        List<String> originList1 = new ArrayList<>(15);
        List<String> originList2 = new ArrayList<>();

        originList1.add(16, "test");


        System.out.println("1-" + originList1.size());
        System.out.println("2-" + originList2.size());
    }

    public static void test_1() {

        HwArrayList_1<String> hwArrayList_1 = new HwArrayList_1<>();

        for (int i = 0; i < 5; i++) {
            hwArrayList_1.add(String.valueOf(i));
        }

        hwArrayList_1.add(11, "11");
        hwArrayList_1.remove(5);

        System.out.println(hwArrayList_1.toString());

    }

    public static void test_2() {

        HwArrayList_2<String> hwArrayList_2 = new HwArrayList_2<>();

        for (int i = 0; i < 10; i++) {
            hwArrayList_2.add(String.valueOf(i));
        }

        hwArrayList_2.remove(5);

        System.out.println(hwArrayList_2.toString());
        System.out.println(hwArrayList_2.size);

        hwArrayList_2.add(5, "5");

        System.out.println(hwArrayList_2.toString());
        System.out.println(hwArrayList_2.size);

    }



}
