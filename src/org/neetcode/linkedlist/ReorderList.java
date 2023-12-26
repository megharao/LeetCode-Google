package org.neetcode.linkedlist;

public class ReorderList {

    public static void reorderList(ListNode head) {
        ListNode s = head, f = head.next;
        //find mid of list
        while(f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        //reverse second half of list
        ListNode second = s.next;
        s.next = null;
        ListNode prev = null;
        while(second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        //merge
        second = prev;
        ListNode first = head;
        while(second != null) { //second < first
            ListNode tmp1 = first.next, tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1.val = 4;
        l1.next = null;
        ListNode l4 = new ListNode();
        l4.val = 3;
        l4.next = l1;
        ListNode l2 = new ListNode();
        l2.val = 2;
        l2.next = l4;
        ListNode l3 = new ListNode();
        l3.val = 1;
        l3.next = l2;
        System.out.println(l3);
        reorderList(l3);
        System.out.println(l3);
    }
}
