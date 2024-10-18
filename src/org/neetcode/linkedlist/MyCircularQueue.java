package org.neetcode.linkedlist;

public class MyCircularQueue {

    LinkedListNode head=null;
    LinkedListNode tail=null;

    int currentLength=0;
    int totalLength=0;

    public MyCircularQueue(int k) {
        head=new LinkedListNode(-1);
        tail=new LinkedListNode(-1);

        head.next=tail;
        head.prev=tail;

        tail.next=head;
        tail.prev =head;

        totalLength=k;
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }

        LinkedListNode left = head.prev;
        LinkedListNode right= head;

        LinkedListNode temp = new LinkedListNode(value);

        temp.next= right;

        right.prev = temp;

        left.next=temp;

        temp.prev=left;

        currentLength++;



        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }

        LinkedListNode left = tail;
        LinkedListNode right= tail.next.next;

        left.next = right;

        right.prev = left;


        currentLength--;

        return true;
    }

    public int Front() {
        if(currentLength<=0){
            return -1;
        }

        return tail.next.val;
    }

    public int Rear() {
        if(currentLength<=0){
            return -1;
        }

        return head.prev.val;
    }

    public boolean isEmpty() {
        return currentLength==0;
    }

    public boolean isFull() {
        return currentLength==totalLength;
    }
}

class LinkedListNode {

    int val;
    LinkedListNode next;
    LinkedListNode prev;
    LinkedListNode(int val) {
        this.val = val;
    }
}
