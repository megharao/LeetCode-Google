package org.neetcode.arrays.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.IntUnaryOperator;

public class MyHashSet {

    int[] arr;
    int initialCapacity = 100;

    public MyHashSet() {
        this.arr = new int[initialCapacity];
        Arrays.fill(arr, Integer.MIN_VALUE);
    }

    public void add(int key) {
        if(key > initialCapacity) {
            initialCapacity += key;
            int[] newArr = new int[initialCapacity];
            newArr = Arrays.copyOf(arr,initialCapacity);
            arr = newArr;
        }
        arr[key] = key;
    }

    public void remove(int key) {
        arr[key] = 0;
    }

    public boolean contains(int key) {
        return arr[key] != 0;
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(1)); // return True
        System.out.println(myHashSet.contains(3)); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2)); // return True
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2)); // return False, (already removed)
        myHashSet.add(1000000);
        System.out.println(myHashSet.contains(1000000));
    }
}