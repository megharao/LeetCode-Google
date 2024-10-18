package org.neetcode.linkedlist;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = head.next;
        ListNode prev = head;
        while(curr != null) {
            if(curr.val >= prev.val) {
                prev = curr;
                curr = curr.next;
                continue;
            }
            ListNode temp = dummy;
            while(curr.val > temp.next.val) {
                temp = temp.next;
            }
            prev.next = curr.next;
            curr.next = temp.next;
            temp.next = curr;
            curr = prev.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
