package org.neetcode.linkedlist;

public class RemoveLinkedListElem {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = head, prev = dummy;
        while(curr != null) {
            if(curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        head.next = two;
        ListNode six1 = new ListNode(6);
        two.next = six1;
        ListNode three = new ListNode(3);
        six1.next = three;
        ListNode four = new ListNode(4);
        three.next = four;
        ListNode five = new ListNode(5);
        four.next = five;
        ListNode six2 = new ListNode(6);
        five.next = six2;
        six2.next = null;
        RemoveLinkedListElem removeLinkedListElem = new RemoveLinkedListElem();
        System.out.println(removeLinkedListElem.removeElements(head,6));
    }
}
