package com.dml.hw.datastructure.linked;

/**
 * @author Louis
 * @version 1.0
 * @since 2019/11/7
 */
public class HwLinkedList_1<E> {

    private Node_1<E> head;

    private Node_1<E> tail;


    public void add(E object) {
        if (head == null) {
            head = new Node_1<>(object);
        }
        else if (tail == null) {
            tail = new Node_1<>(object);
            head.setNext(tail);
        }
        else {
            Node_1<E> next = new Node_1(object);
            tail.setNext(next);
            tail = next;
        }
    }


    public void add(int index, E object) {

        Node_1 prev = null;
        Node_1 next = head;

        for (int i = 0; i <= index; i++) {

            next = next.getNext();
            if (i == index - 1) {
                prev = next;
            }

        }

        Node_1 current = new Node_1(object);
        prev.setNext(current);
        current.setNext(next);
    }

    public void remove() {

    }

    public void remove(int index, E object) {

    }


    public void reversal() {

        Node_1 prev = null;
        Node_1 current = head;
        Node_1 next = null;

        while (true) {

            if (current == head) {
                prev = current;
                current = current.getNext();
                prev.setNext(null);
                tail = prev;

            } else {
                if (current == null) {
                    head = prev;
                    break;
                }

                next = current.getNext();
                current.setNext(prev);
                prev = current;
                current = next;
            }
        }
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node_1 next = head;
        while (next != null) {
            sb.append(next.getObject());
            next = next.getNext();
        }
        return sb.toString();
    }
}
