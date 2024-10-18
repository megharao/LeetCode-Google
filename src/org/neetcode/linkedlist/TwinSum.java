package org.neetcode.linkedlist;

public class TwinSum {
    public int pairSum(ListNode head) {
        ListNode fast = head, slow = head;
        //find middle
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //reverse second half
        ListNode prev = null;
        while(slow != null) {
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        ListNode left = head, right = prev;
        int sum = Integer.MIN_VALUE;
        while(right != null) {
            sum = Math.max(sum, left.val+right.val);
            left = left.next;
            right = right.next;
        }
        return sum;
    }
}
