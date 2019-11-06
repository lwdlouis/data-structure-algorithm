package com.dml.hw.datastructure.array;

import java.util.Arrays;

/**
 * @author Louis
 * @version 1.0
 * @since 2019/11/6
 */
public class HwArrayList_2<E> {

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;


    /**
     * Shared empty array instance used for empty instances.
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};

    /**
     * Shared empty array instance used for default sized empty instances. We
     * distinguish this from EMPTY_ELEMENTDATA to know how much to inflate when
     * first element is added.
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};


    transient Object[] elementData;

    public int size;


    public HwArrayList_2(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public HwArrayList_2() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }


    public void add(E object) {
        grow(size + 1);

        elementData[size++] = object;
    }

    public void add(int index, E object) {
        grow(size + 1);

        System.arraycopy(elementData, index, elementData, index + 1, size - index);

        size++;
        elementData[index] = object;
    }

    public void remove() {
        elementData[--size] = null;
    }

    public void remove(int index) {

        System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
        elementData[--size] = null;
    }

    public void grow(int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            this.elementData = new Object[10];
        }

        if (this.elementData.length < minCapacity) {
            int oldCapacity = this.elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);

            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }


    @Override
    public String toString() {
        return Arrays.toString(elementData);
    }


}
