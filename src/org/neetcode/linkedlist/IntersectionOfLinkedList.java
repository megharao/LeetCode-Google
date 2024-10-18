package org.neetcode.linkedlist;

public class IntersectionOfLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA, currB = headB;

        while(currA != currB) {
            currA = (currA != null) ? currA.next : headA;
            currB = (currB != null) ? currB.next : headA;
        }
        return currA;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l11 = new ListNode(1);
        l1.next = l11;
        ListNode l12 = new ListNode(8);
        l11.next = l12;
        ListNode l13 = new ListNode(4);
        l12.next = l13;
        ListNode l14 = new ListNode(5);
        l13.next = l14;

        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        l2.next = l21;
        ListNode l22 = new ListNode(1);
        l21.next = l22;
        l22.next = l12;

        IntersectionOfLinkedList intersectionOfLinkedList = new IntersectionOfLinkedList();
        System.out.println(intersectionOfLinkedList.getIntersectionNode(l1,l2));
    }
}
