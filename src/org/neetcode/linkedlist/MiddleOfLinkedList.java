package org.neetcode.linkedlist;

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast!= null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null && fast.next != null) {
            return slow.next;
        } else {
            return slow;
        }
    }
}
