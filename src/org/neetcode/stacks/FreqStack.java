package org.neetcode.stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FreqStack {

    Map<Integer, Integer> valueToCount;
    HashMap<Integer, Stack<Integer>> countToStack;
    int maxCount = 0;
    public FreqStack() {
        valueToCount = new HashMap<>();
        countToStack = new HashMap<>();
    }

    public void push(int val) {
        int count = valueToCount.getOrDefault(val,0);
        count++;
        if(count > maxCount) {
            maxCount = count;
            countToStack.put(maxCount, new Stack<>());
        }
        countToStack.get(count).push(val);
        valueToCount.put(val,count);
    }

    public int pop() {
        int value = countToStack.get(maxCount).pop();
        valueToCount.put(value, valueToCount.get(value)-1);
        if(countToStack.get(maxCount).isEmpty()) {
            maxCount--;
        }
        return value;
    }
}
