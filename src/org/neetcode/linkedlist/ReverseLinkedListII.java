package org.neetcode.linkedlist;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0,head);
        ListNode leftPrev = dummy;
        ListNode curr = head;
        //Reach node at left position
        for(int i = 0; i < left-1; i++) {
            leftPrev = curr;
            curr = curr.next;
        }
        //Now curr = left, leftPrev = node before left
        //Reverse from left to right
        ListNode prev = null;
        for(int i = 0; i < right-left+1; i++) {
            ListNode tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }
        leftPrev.next.next = curr;
        leftPrev.next = prev;
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
