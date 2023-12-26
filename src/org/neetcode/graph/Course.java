package org.neetcode.graph;

import java.util.*;

public class Course {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> prereq = new HashMap<>();
        for(int i = 0; i < numCourses; i++) {
            prereq.put(i, new ArrayList<>());
        }
        for(int[] p: prerequisites) {
            int course = p[0];
            int pre = p[1];
            prereq.get(course).add(pre);
        }
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i,visited,prereq)) return false;
        }
        return true;
    }

    public boolean dfs(int course, Set<Integer> visited, Map<Integer, List<Integer>> prereq) {
        if(visited.contains(course))
            return false;
        if(prereq.get(course).isEmpty())
            return true;
        visited.add(course);
        for(int p: prereq.get(course)) {
            if(!dfs(p, visited,prereq)) return false;
        }
        visited.remove(course);
        prereq.put(course,new ArrayList<>());
        return true;
    }
}
