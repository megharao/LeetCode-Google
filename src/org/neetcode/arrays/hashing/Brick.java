package org.neetcode.arrays.hashing;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Brick {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> countGap = new HashMap<>();
        for(int i = 0; i < wall.size(); i++) {
            int total = 0;
            for(int j = 0; j < wall.get(i).size()-1; j++) {
                total += wall.get(i).get(j);
                countGap.put(total,1+countGap.getOrDefault(total,0));
            }
        }
        int maxGap = countGap.values().stream().max(Comparator.comparingInt(Integer::intValue)).orElse(0);
        return wall.size() - maxGap;
    }

    public static void main(String[] args) {
        int[][] wall = {{1,2,2,1},{3,1,2},{1,3,2},{2,4},{3,1,2},{1,3,1,1}};
        Brick brick = new Brick();
        List<List<Integer>> bricks = Arrays.stream(wall)
                .map(row -> IntStream.of(row).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());
        System.out.println(brick.leastBricks(bricks));
    }
}
