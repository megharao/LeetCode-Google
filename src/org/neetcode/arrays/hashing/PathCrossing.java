package org.neetcode.arrays.hashing;

import java.util.HashSet;
import java.util.Set;

public class PathCrossing {
    public static boolean isPathCrossing(String path) {
        Set<String> visited = new HashSet<>();
        int x = 0, y = 0;
        for(char c: path.toCharArray()) {
            String visit = getNewCoord(x,y, c);
            if(visited.contains(visit)) {
                return true;
            }
            visited.add(visit);
        }
        return false;
    }

    public static String getNewCoord(int x, int y, char c) {
        switch(c) {
            case 'N':
                y++;
                break;
            case 'E':
                x++;
                break;
            case 'S':
                y--;
                break;
            case 'W':
                x--;
                break;
        }
        return x+"#"+y;
    }

    public static void main(String[] args) {
        String path = "NESWW";
        System.out.println(isPathCrossing(path));
    }
}
