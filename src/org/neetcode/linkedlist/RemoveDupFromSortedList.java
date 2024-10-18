package org.neetcode.linkedlist;

public class RemoveDupFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode q = null;
        ListNode r = head;
        while(r != null) {
            if(q != null && q.val == r.val) {
                r = r.next;
                q.next = r;
            } else {
                q = r;
                r = r.next;
            }
        }
        return head;
    }
}
