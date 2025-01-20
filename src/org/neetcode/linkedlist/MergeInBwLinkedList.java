package org.neetcode.linkedlist;

public class MergeInBwLinkedList {
    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode aPtr = null, bPtr = null;
        ListNode curr = list1; int count = 0;
        while(curr != null) {
            if(count == a-1) {
                aPtr = curr;
            }
            if(count == b+1) {
                bPtr = curr;
                break;
            }
            curr = curr.next;
            count++;
        }
        aPtr.next = list2;
        curr = list2;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = bPtr;
        return list1;
    }

    public static void main(String[] args) {
        //10,1,13,6,9,5
        ListNode list1e = new ListNode(5,null);
        ListNode list1d = new ListNode(9,list1e);
        ListNode list1c = new ListNode(6,list1d);
        ListNode list1b = new ListNode(13,list1c);
        ListNode list1a = new ListNode(1,list1b);
        ListNode list1 = new ListNode(10,list1a);

        //[1000000,1000001,1000002]
        ListNode list2b = new ListNode(1000002,null);
        ListNode list2a = new ListNode(1000001,list2b);
        ListNode list2 = new ListNode(1000000,list2a);
        System.out.println(mergeInBetween(list1, 3,4,list2));
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
