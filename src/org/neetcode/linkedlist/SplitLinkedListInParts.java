package org.neetcode.linkedlist;

public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] listNodes = new ListNode[k];
        int len=0;
        ListNode curr = head;
        while(curr != null) {
            curr = curr.next;
            len++;
        }
        int base_len = len/k, numOfExtraNodeList = len%k;
        curr = head;
        for(int i = 0; i < k; i++) {
            ListNode dummy = new ListNode(0), currHead = dummy;
            for(int j = 0; j < base_len+(i<numOfExtraNodeList ? 1:0); j++) {
                currHead = currHead.next = new ListNode(curr.val);
                if(curr != null) {
                    curr=curr.next;
                }
                listNodes[i] = dummy.next;
            }
        }
        return listNodes;
    }

    public static void main(String[] args) {

    }
}
