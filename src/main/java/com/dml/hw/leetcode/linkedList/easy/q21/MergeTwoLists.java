package com.dml.hw.leetcode.linkedList.easy.q21;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 21. 合并两个有序链表
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {


    public static void main(String[] args) {

        ListNode l1 = createListNode(new int[]{1,2,4});
        ListNode l2 = createListNode(new int[]{1,3,4});

//        ListNode l1 = createListNode(new int[]{});
//        ListNode l2 = createListNode(new int[]{});

        ListNode result = mergeTwoLists(l1, l2);

        ListNode temp = result;
        while (true) {
            if (temp == null) {
                return;
            }
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode temp = null;
        ListNode result = null;

        if (l1 != null || l2 != null) {
            temp = new ListNode();
            result = temp;
        }

        while (l1 != null || l2 != null) {

            int v1 = l1 != null ? l1.val : Integer.MAX_VALUE;
            int v2 = l2 != null ? l2.val : Integer.MAX_VALUE;

            if (v1 <= v2) {
                temp.val = v1;
                l1 = l1.next;
            } else {
                temp.val = v2;
                l2 = l2.next;
            }

            if (temp != null && result == null) {
                result = temp;
            }

            if (l1 != null || l2 != null) {
                ListNode next = new ListNode();
                temp.next = next;
                temp = next;
            }
        }
        return result;
    }

    public static ListNode createListNode(int[] values) {

        ListNode first = null;
        ListNode l = null;
        for (int i = 0; i < values.length; i++) {
            int val = values[i];
            if (i == 0) {
                l = new ListNode(val);
                first = l;
                continue;
            }
            l.next = new ListNode(val);
            l = l.next;
        }
        return first;
    }


}
