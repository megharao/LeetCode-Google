package org.neetcode.arrays.hashing;

import java.util.*;

public class DestinationCity {
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        for(var p: paths) {
            map.put(p.get(0), p.get(1));
        }
        String dest = "";
        for(var p: paths) {
            if(map.get(p.get(1)) == null) {
                dest = p.get(1);
            }
        }
        return dest;
    }

    public static void main(String[] args) {
        String[][] paths = {{"B","C"},{"D","B"},{"C","A"}};
        List<List<String>> list = new ArrayList<>();
        for(String[] path : paths) {
            List<String> l = new ArrayList<>();
            l.add(path[0]);
            l.add(path[1]);
            list.add(l);
        }
        DestinationCity destinationCity = new DestinationCity();
        System.out.println(destinationCity.destCity(list));
    }
}
