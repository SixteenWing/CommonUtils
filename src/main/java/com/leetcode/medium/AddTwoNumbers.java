package com.leetcode.medium;

/**
 * Created by arthur.hw on 2018/12/14.
 *
 * num.2 https://leetcode-cn.com/problems/add-two-numbers
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode f3 = newNode(l1, l2, 0);

        return f3;
    }

    private ListNode newNode(ListNode f1, ListNode f2, int upX) {

        if (f1 == null && f2 == null && upX == 0) {
            return null;
        }

        int addNum = (f1 == null ? 0 : f1.val) + (f2 == null ? 0 : f2.val) + upX;

        ListNode newNode = new ListNode(addNum % 10);

        newNode.next = newNode(f1 == null ? null : f1.next, f2 == null ? null : f2.next, addNum / 10);

        return newNode;
    }

    public static void main(String[] args) {

        ListNode l11 = new ListNode(8);
        l11.next = null;
        ListNode l1 = new ListNode(5);
        l1.next = null;
        ListNode l2 = new ListNode(5);
        l2.next = null;

        AddTwoNumbers client = new AddTwoNumbers();

        ListNode retNode = client.addTwoNumbers(l1, l2);

        System.out.println("---");
    }
}
