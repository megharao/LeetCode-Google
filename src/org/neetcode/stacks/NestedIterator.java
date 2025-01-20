package org.neetcode.stacks;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class NestedIterator implements Iterator<Integer> {

    Stack<Integer> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        dfs(nestedList);
        stack = stack.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                            Collections.reverse(list);
                            return new Stack<Integer>() {{
                                addAll(list);
                            }};
                        }
                ));
    }

    @Override
    public Integer next() {
        return stack.pop();
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public void dfs(List<NestedInteger> nestedList) {
        for(NestedInteger n: nestedList) {
            if(n.isInteger()) {
                stack.push(n.getInteger());
            } else {
                dfs(n.getList() );
            }
        }
    }
}

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {
      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return empty list if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }