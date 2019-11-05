package com.dml.hw.datastructure.array;


import java.util.Arrays;

/**
 * @author Louis
 * @version 1.0
 * @since 2019/11/5
 */
public class HwArrayList_1<E> {

    /**
     * 初始化
     */
    Object[] elementData;

    int DEFAULT_CAPACITY = 10;

    int size = 0;


    public HwArrayList_1() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public HwArrayList_1(int capacity) {
        elementData = new Object[capacity];
    }


    /**
     * 增
     */
    /**
     * Appends the specified element to the end of this list.
     *
     * @param e element to be appended to this list
     * @return <tt>true</tt> (as specified by
     */
    public boolean add(E e) {

        size++;

        if (size >= elementData.length) {
            grow();
        }

        elementData[size - 1] = e;
        return true;
    }

    public void add(int index, E element) {
        size++;
        int newLength = elementData.length;

        if (size > elementData.length) {
            newLength = Double.valueOf(elementData.length * 1.5).intValue();
        }

        Object[] newElementData = new Object[newLength];

        System.arraycopy(elementData, 0, newElementData, 0, index - 1);
        newElementData[index] = element;

        if (elementData.length < index) {
            System.arraycopy(elementData, index, newElementData, index + 1, elementData.length);
        }

        elementData = newElementData;
    }


    /**
     * 删
     */

    public E remove(int index) {
        return null;
    }


    private void grow() {
        elementData = Arrays.copyOf(elementData, Double.valueOf(elementData.length * 1.5).intValue());
    }

    @Override
    public String toString() {
        return Arrays.toString(elementData);
    }
}
