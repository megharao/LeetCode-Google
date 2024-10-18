package org.neetcode.linkedlist;

public class SwapNodes {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode curr = head;
        for(int i = 1; i < k; i++) {
            curr = curr.next;
        }
        ListNode left = curr;
        ListNode right = head;
        while(curr.next != null) {
            curr = curr.next;
            right = right.next;
        }
        int temp = right.val;
        right.val = left.val;
        left.val = temp;
        return head;
    }
}
