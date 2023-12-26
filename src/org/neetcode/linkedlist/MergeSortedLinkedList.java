package org.neetcode.linkedlist;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class MergeSortedLinkedList {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merged = new ListNode();
        ListNode temp1 = list1, temp2 = list2, temp3 = merged, prev = null;
        while(temp1 != null && temp2 != null) {
            if(temp1.val <= temp2.val) {
                if(temp3 == null)
                    temp3 = new ListNode();
                temp3.val = temp1.val;
                if(prev != null)
                    prev.next = temp3;
                prev = temp3;
                temp1 = temp1.next;
                temp3 = temp3.next;
            } else {
                if(temp3 == null)
                    temp3 = new ListNode();
                temp3.val = temp2.val;
                if(prev != null)
                    prev.next = temp3;
                prev = temp3;
                temp2 = temp2.next;
                temp3 = temp3.next;
            }
        }
        ListNode temp = temp1 == null ? temp2 : temp1;
        temp3 = temp;
        if(prev != null)
            prev.next = temp3;
        return merged.next == null ? temp3 : merged;
    }



    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1.val = 4;
        l1.next = null;
        ListNode l2 = new ListNode();
        l2.val = 2;
        l2.next = l1;
        ListNode l3 = new ListNode();
        l3.val = 1;
        l3.next = l2;
        ListNode l4 = new ListNode();
        l4.val = 4;
        l4.next = null;
        ListNode l5 = new ListNode();
        l5.val = 3;
        l5.next = l4;
        ListNode l6 = new ListNode();
        l6.val = 1;
        l6.next = l5;
        System.out.println(l3);
        System.out.println(l6);
        System.out.println(mergeTwoLists(null,l1));
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.poll();
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        ListNode temp = this;
        String str = "";
        while (temp != null) {
            str += temp.val + "->";
            temp = temp.next;
        }
//        str += temp.val;
        return str;
    }
}
