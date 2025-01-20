package org.neetcode.linkedlist;

public class RemoveNodesFromLinkedList {
    public static ListNode removeNodes(ListNode head) {
        head = reverseListNode(head);
        ListNode curr = head;
        int currMax = curr.val;
        while(curr != null && curr.next != null) {
            if(curr.next.val <currMax) {
                curr.next = curr.next.next;
            } else {
                currMax = curr.next.val;
                curr = curr.next;
            }
        }
        return reverseListNode(head);
    }

    public static ListNode reverseListNode(ListNode head) {
        ListNode prev = null, curr = head;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        //[5,2,13,3,8]
        ListNode node8 = new ListNode(8,null);
        ListNode node3 = new ListNode(3,node8);
        ListNode node13 = new ListNode(13,node3);
        ListNode node2 = new ListNode(2,node13);
        ListNode node5 = new ListNode(5,node2);
        System.out.println(removeNodes(node5));
    }
}
