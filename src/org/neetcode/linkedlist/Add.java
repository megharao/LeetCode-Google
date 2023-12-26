package org.neetcode.linkedlist;

public class Add {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        int carry = 0;
        ListNode curr1 = l1, curr2 = l2, currRes = res;
        ListNode prev = null;
        while(curr1 != null && curr2 != null) {
            int sum = curr1.val + curr2.val +carry;
            if(currRes == null)
                currRes = new ListNode(sum % 10);
            else
                currRes.val = sum % 10;
            carry = sum / 10;
            if(prev != null) {
                prev.next = currRes;
            }
            prev = currRes;
            curr1 = curr1.next;
            curr2 = curr2.next;
            currRes = currRes.next;
        }
        ListNode curr = curr1 == null ? curr2 : curr1;
        while(curr != null) {
            int sum = curr.val + carry;
            currRes = new ListNode(sum % 10);
            carry = sum/10;
            prev.next = currRes;
            prev = currRes;
            curr = curr.next;
            currRes = currRes.next;
        }
        if(carry != 0) {
            currRes = new ListNode(carry);
            prev.next = currRes;
            prev = currRes;
        }
        return res;
    }

    public static void main(String[] args) {
//        9,9,9,9,9,9,9

        ListNode l1111111 = new ListNode();
        l1111111.val = 9;
        l1111111.next = null;
        ListNode l111111 = new ListNode();
        l111111.val = 9;
        l111111.next = l1111111;
        ListNode l11111 = new ListNode();
        l11111.val = 9;
        l11111.next = l111111;
        ListNode l1111 = new ListNode();
        l1111.val = 9;
        l1111.next = l11111;
        ListNode l111 = new ListNode();
        l111.val = 9;
        l111.next = l1111;
        ListNode l11 = new ListNode();
        l11.val = 2;
        l11.next = null;
        ListNode l1 = new ListNode();
        l1.val = 9;
        l1.next = l11;

        ListNode l2222 = new ListNode();
        l2222.val = 9;
        l2222.next = null;
        ListNode l222 = new ListNode();
        l222.val = 9;
        l222.next = l2222;
        ListNode l22 = new ListNode();
        l22.val = 7;
        l22.next = null;
        ListNode l2 = new ListNode();
        l2.val = 3;
        l2.next = l22;

        System.out.println(l1);
        System.out.println(l2);

        System.out.println(addTwoNumbers(l1,l2));


    }
}
