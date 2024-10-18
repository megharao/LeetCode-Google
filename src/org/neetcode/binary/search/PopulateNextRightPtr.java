package org.neetcode.binary.search;

public class PopulateNextRightPtr {
    public Node connect(Node root) {
        Node curr = root;
        Node nxt = curr != null ? curr.left : null;
        while(curr != null && nxt != null) {
            curr.left.next = curr.right;
            if(curr.next != null) {
                curr.right.next = curr.next.left;
            }
            curr = curr.next;
            if(curr == null) {
                curr = nxt;
                nxt = curr.left;
            }
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
