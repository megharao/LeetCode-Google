package org.neetcode.graph;

import java.util.*;

public class CourseII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();
        Map<Integer, List<Integer>> prereq = new HashMap<>();
        for(int i = 0; i < numCourses; i++) {
            prereq.put(i, new ArrayList<>());
        }
        for(int[] p: prerequisites) {
            int course = p[0];
            int pre = p[1];
            prereq.get(course).add(pre);
        }
        List<Integer> res = new ArrayList<>();
        int[] arr = new int[0];
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, visited,cycle,prereq,res)) return arr;
        }
        arr = new int[res.size()];
        int index = 0;
        for(int i: res) {
            arr[index] = i;
            index++;
        }
        return arr;
    }

    public boolean dfs(int course, Set<Integer> visited, Set<Integer> cycle,Map<Integer, List<Integer>> prereq, List<Integer> res) {
        if(cycle.contains(course))
            return false;
        if(visited.contains(course))
            return true;
        cycle.add(course);
        for(Integer pre: prereq.get(course)) {
            if(!dfs(pre,visited,cycle,prereq,res)) return false;
        }
        cycle.remove(course);
        visited.add(course);
        res.add(course);
        return true;
    }
}
