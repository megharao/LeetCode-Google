package org.neetcode.arrays.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumOfStudentsHungry {
    public static int countStudents(int[] students, int[] sandwiches) {
        int res = students.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, (int) Arrays.stream(students).filter(i -> i == 0).count());
        map.put(1, (int) Arrays.stream(students).filter(i -> i == 1).count());
        for(int sandwich : sandwiches) {
            if(map.get(sandwich) > 0) {
                res --;
                map.put(sandwich, map.get(sandwich)-1);
            } else {
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] students = {1,1,0,0};
        int[] sandwiches = {0,1,0,1};
        System.out.println(countStudents(students, sandwiches));
    }
}
