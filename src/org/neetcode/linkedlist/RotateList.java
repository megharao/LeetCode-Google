package org.neetcode.linkedlist;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }
        int size = 1;
        ListNode temp = head;
        while(temp.next != null) {
            size++;
            temp = temp.next;
        }
        temp.next = head;
        k = k % size; // if k > size, can rotate more than size times
        k = size - k;
        while(k > 0) {
            temp = temp.next;
            k--;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }
}
