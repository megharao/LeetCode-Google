package org.neetcode.math.geometry;

import java.util.*;

class DetectSquares {

    Map<Point, Integer> map;
    List<Point> list;
    public DetectSquares() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public void add(int[] point) {
        Point p = new Point(point[0],point[1]);
        if(map.containsKey(p)) {
            int count = map.get(p);
            count++;
            map.put(p,count);
        }
        map.put(p,1);
        list.add(p);
    }

    public int count(int[] point) {
        int res = 0;
        for(Point i : list) {
            if(Math.abs(i.x-point[0]) != Math.abs(i.y-point[1]) || i.x == point[0] || i.y == point[1]) {
                continue;
            }
            if(map.containsKey(new Point(i.x,point[1])) && map.containsKey(new Point(point[0],i.y))) {
                res += map.get(new Point(i.x,point[1])) * map.get(new Point(point[0],i.y));
            }
        }
        return res;
    }
}
class Point{
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
