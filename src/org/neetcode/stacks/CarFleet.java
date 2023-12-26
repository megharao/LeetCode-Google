package org.neetcode.stacks;

import java.util.*;

public class CarFleet {

    class Pair {
        int pos;
        int sp;

        Pair(int pos, int sp) {
            this.pos = pos;
            this.sp = sp;
        }

        int getPos() {
            return this.pos;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair> pairs = new ArrayList<>();
        for(int i = 0; i < position.length; i++) {
            Pair pair = new Pair(position[i], speed[i]);
            pairs.add(pair);
        }
        pairs.sort(Comparator.comparing(Pair::getPos));
        Stack<Double> fleet = new Stack<>();
        for(int i = pairs.size()-1; i >= 0; i--) {
            double time = ((double)(target - pairs.get(i).pos) / pairs.get(i).sp);
            fleet.push(time);
            if(fleet.size() >= 2 && fleet.peek() <= fleet.get(fleet.size()-2)) {
                fleet.pop();
            }
        }
        return fleet.size();
    }

    public static void main(String[] args) {
        int target = 10;
        int[] position = {6,8};
        int[] speed = {3,2};
        CarFleet car = new CarFleet();
        System.out.print(car.carFleet(target,position,speed));
    }
}
