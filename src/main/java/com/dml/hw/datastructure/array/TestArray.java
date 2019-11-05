package com.dml.hw.datastructure.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Louis
 * @version 1.0
 * @since 2019/11/5
 */
public class TestArray {

    public void origin() {
        List<String> originList = new ArrayList<>();
    }

    public static void main(String[] args) {

        HwArrayList_1<String> hwArrayList_1 = new HwArrayList_1<>();

        for (int i = 0; i < 5; i++) {
            hwArrayList_1.add(String.valueOf(i));
        }

        hwArrayList_1.add(11, "11");
        hwArrayList_1.remove(5);

        System.out.println(hwArrayList_1.toString());
    }
}
