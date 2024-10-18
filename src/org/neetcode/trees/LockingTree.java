package org.neetcode.trees;

import java.util.*;

public class LockingTree {

    int[] parent;
    int[] locked;
    Map<Integer, List<Integer>> child;
    public LockingTree(int[] parent) {
        this.parent = parent;
        this.locked = new int[parent.length];
        this.child = new HashMap<>();
        Arrays.fill(locked,Integer.MIN_VALUE);
        for(int i = 0; i < parent.length; i++) {
            if(!child.containsKey(parent[i])) {
                child.put(parent[i],new ArrayList<>());
            }
            child.get(parent[i]).add(i);
        }
    }

    public boolean lock(int num, int user) {
        if(locked[num] != Integer.MIN_VALUE) return false;
        locked[num] = user;
        return true;
    }

    public boolean unlock(int num, int user) {
        if(locked[num] != user) return false;
        locked[num] = Integer.MIN_VALUE;
        return true;
    }

    public boolean upgrade(int num, int user) {
        int i = num;
        while(i!=-1) {
            if(locked[i] != Integer.MIN_VALUE)
                return false;
            i = parent[i];
        }
        int lockedCount = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(num);
        while(!q.isEmpty()) {
            int n = q.poll();
            if(locked[n] != Integer.MIN_VALUE) {
                locked[n] = Integer.MIN_VALUE;
                lockedCount++;
            }
            q.addAll(child.getOrDefault(n,new ArrayList<>()));
        }
        if(lockedCount > 0) {
            locked[num] = user;
        }
        return lockedCount>0;
    }

    public static void main(String[] args) {
        int[] parent = {-1, 0, 0, 1, 1, 2, 2};
        LockingTree lockingTree = new LockingTree(parent);
        lockingTree.lock(2, 2);    // return true because node 2 is unlocked.
        // Node 2 will now be locked by user 2.
        lockingTree.unlock(2, 3);  // return false because user 3 cannot unlock a node locked by user 2.
        lockingTree.unlock(2, 2);  // return true because node 2 was previously locked by user 2.
        // Node 2 will now be unlocked.
        lockingTree.lock(4, 5);    // return true because node 4 is unlocked.
        // Node 4 will now be locked by user 5.
        lockingTree.upgrade(0, 1); // return true because node 0 is unlocked and has at least one locked descendant (node 4).
        // Node 0 will now be locked by user 1 and node 4 will now be unlocked.
        lockingTree.lock(0, 1);    // return false because node 0 is already locked.
    }
}
