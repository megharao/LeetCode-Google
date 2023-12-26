package org.neetcode.arrays.hashing;

import java.util.*;

public class InterRec {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double, List<String>> set = new HashMap<>();
        long count = 0;
        for(int i = 0; i < rectangles.length; i++) {
            double ratio = (double)rectangles[i][0]/rectangles[i][1];
                if(set.containsKey(ratio)) {
                    count += set.get(ratio).size();
                    set.get(ratio).add(rectangles[i][0]+"/"+rectangles[i][1]);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(rectangles[i][0]+"/"+rectangles[i][1]);
                    set.put(ratio,list);
                }
        }
        return count;
    }

    public static void main(String[] args) {
        InterRec i = new InterRec();
        int[][] rectangles = {{4,8},{3,6},{10,20},{15,30}};
        System.out.println(i.interchangeableRectangles(rectangles));
    }
}
