package org.neetcode.linkedlist;

public class PaliLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
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
        //check palindrome
        ListNode left = head, right = prev;
        while(right != null){
            if(right.val != left.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next = new ListNode(2);
        head.next = next;
        PaliLinkedList paliLinkedList = new PaliLinkedList();
        System.out.println(paliLinkedList.isPalindrome(head));
    }
}
