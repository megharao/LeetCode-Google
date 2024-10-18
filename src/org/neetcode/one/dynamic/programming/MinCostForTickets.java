package org.neetcode.one.dynamic.programming;

import java.util.HashMap;
import java.util.Map;

public class MinCostForTickets {
    Map<Integer, Integer> dp;
    public int mincostTickets(int[] days, int[] costs) {
         dp = new HashMap<>();
         return dfs(0,days,costs);
    }

    public int dfs(int i, int[] days, int[] costs) {
        if(i == days.length) {
            return 0;
        }
        if(dp.containsKey(i)) {
            return dp.get(i);
        }
        dp.put(i, Integer.MAX_VALUE);
        int[] numOfDays = {1,7,30};
        for(int j = 0; j < costs.length; j++) {
            int d = numOfDays[j];
            int c = costs[j];
            int k = i;//to travel to the day in the days array where next travel pass has to be bought based on the decision of num of days of travel pass we currently took
            while(k < days.length && days[k] < days[i]+d) {
                k++;
            }
            dp.put(i, Math.min(dp.get(i), c + dfs(k,days,costs)));
        }
        return dp.get(i);
    }
}
