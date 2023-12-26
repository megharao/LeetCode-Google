package org.neetcode.arrays.hashing;

import java.util.*;
import java.util.stream.Collectors;

public class PushDominoes {
    public String pushDominoes(String dominoes) {
        Queue<String> queue = new ArrayDeque<>();
        List<String> list = dominoes.chars().mapToObj(c -> String.valueOf((char)c)).collect(Collectors.toList());
        for(int i = 0; i < list.size(); i++) {
            if(!".".equals(list.get(i))) {
                queue.add(i+"#"+list.get(i));
            }
        }
        while(!queue.isEmpty()) {
            String item = queue.poll();
            int i = Integer.parseInt(item.split("#")[0]);
            String d = item.split("#")[1];
            if("L".equals(d) && i > 0 && ".".equals(list.get(i-1))) {
                queue.add(i-1+"#"+"L");
                list.set(i-1,"L");
            } else if("R".equals(d)){
                if(i+1 < list.size() && ".".equals(list.get(i+1))) {
                    if(i+2 < list.size() && "L".equals(list.get(i+2))) {
                        queue.poll();
                    } else {
                        queue.add(i+1+"#"+"R");
                        list.set(i+1,"R");
                    }
                }
            }
        }
        return list.stream().reduce("", String::concat).toString();
    }

    public static void main(String[] args) {
        PushDominoes pushDominoes = new PushDominoes();
        System.out.println(pushDominoes.pushDominoes("RR.L"));
    }
}
