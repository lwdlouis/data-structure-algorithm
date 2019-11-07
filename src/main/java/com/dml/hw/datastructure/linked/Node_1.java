package com.dml.hw.datastructure.linked;

import lombok.Data;

/**
 * @author Louis
 * @version 1.0
 * @since 2019/11/7
 */

@Data
public class Node_1<E> {

    private Node_1 prev;
    private Node_1 next;

    private E object;

    public Node_1(E object) {
        this.object = object;
    }

}
