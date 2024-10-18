package org.neetcode.linkedlist;

public class BrowserHistory {

    Node head;
    Node current;
    public BrowserHistory(String homepage) {
        head = new Node(homepage);
        current = head;
    }

    public void visit(String url) {
        current.next = new Node(url);
        current.next.prev = current;
        current = current.next;
    }

    public String back(int steps) {
        while(steps > 0 && current.prev != null) {
            current = current.prev;
            steps--;
        }
        return current.url;
    }

    public String forward(int steps) {
        while(steps > 0 && current.next!= null) {
            current = current.next;
            steps--;
        }
        return current.url;
    }

    class Node {
        String url;
        Node next;
        Node prev;
        Node(String url) {
            this.url = url;
            next = prev = null;
        }
    }
}
