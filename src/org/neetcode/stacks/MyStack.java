package org.neetcode.stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class MyStack {
    Deque<Integer> q;
    public MyStack() {
        q = new ArrayDeque<>();
    }

    public void push(int x) {
        q.addLast(x);
    }

    public int pop() {
        int size = q.size();
        for(int i = 0; i < size - 1; i++)
            push(q.pollFirst());
        return q.pollFirst();
    }

    public int top() {
        int size = q.size();
        for(int i = 0; i < size - 1; i++)
            push(q.pollFirst());

        int res = q.peekFirst();
        push(q.pollFirst());
        return res;
    }

    public boolean empty() {
        return q.size() == 0;
    }

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(6);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
    }
}