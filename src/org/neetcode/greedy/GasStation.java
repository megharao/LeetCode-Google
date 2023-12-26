package org.neetcode.greedy;

import java.util.Arrays;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = Arrays.stream(gas).sum();
        int costSum = Arrays.stream(cost).sum();
        if(gasSum < costSum) {
            return -1;
        }
        int res = 0;
        for(int i = 0; i < gas.length; i++) {
            int total = cost[i] - gas[i];
            if(total < 0) {
                total = 0;
                res = i+1;
            }
        }
        return res;
    }
}
