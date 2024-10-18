package org.neetcode.linkedlist;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(); //store val < x
        ListNode right = new ListNode(); //store val >= x
        ListNode leftTail = left, rightTail = right, curr = head;
        while(curr != null) {
            if(curr.val < x) {
                leftTail.next = curr;
                leftTail = leftTail.next;
            } else {
                rightTail.next = curr;
                rightTail = rightTail.next;
            }
            curr = curr.next;
        }
        //connect two list
        leftTail.next = right.next;
        rightTail.next = null;
        return left.next;
    }
}
