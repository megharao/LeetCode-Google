package org.neetcode.linkedlist;

public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        for(int i = 1; i <= n; i++) {
            fast = fast.next;
        }
        while(fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = slow.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode();
        l5.val = 5;
        l5.next = null;
        ListNode l1 = new ListNode();
        l1.val = 4;
        l1.next = l5;
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
        System.out.println(removeNthFromEnd(l3,2));
    }
}
