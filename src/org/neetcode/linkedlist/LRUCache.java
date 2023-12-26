package org.neetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Map<Integer, Node> map;
    Node lru;
    Node mru;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        lru = new Node(0,0);
        mru = new Node(0,0);
        this.lru.next = mru;
        this.mru.prev = lru;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            remove(map.get(key));
            insert(map.get(key));
            return map.get(key).value;
        }
        return -1;
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void insert(Node node) {
        Node prev = mru.prev;
        Node next = mru;
        prev.next = next.prev = node;
        node.next = next;
        node.prev = prev;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            remove(map.get(key));
        }
        Node node = new Node(key, value);
        this.map.put(key, node);
        insert(node);
        if(map.size() > capacity) {
            Node templru = lru.next;
            remove(templru);
            map.remove(templru.key);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        lruCache.put(4,4);
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(1));
        lruCache.put(5,5);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(5));
    }
}

class Node {
    int key;
    int value;
    Node next;
    Node prev;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }

}
