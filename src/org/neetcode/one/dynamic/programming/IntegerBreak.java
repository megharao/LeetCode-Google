package org.neetcode.one.dynamic.programming;

import java.util.HashMap;
import java.util.Map;

public class IntegerBreak {
    Map<Integer, Integer> dp;
    public int integerBreak(int n) {
        dp = new HashMap<>();
        dp.put(1,1);
        return dfs(n,n);
    }

    public int dfs(int num, int n) {
        if(dp.containsKey(num)) {
            return dp.get(num);
        }
        dp.put(num, (num == n) ? 0 : num);
        for(int i = 1; i < num; i++) {
            int val = dfs(i,n)*dfs(num-i,n);
            dp.put(num,Math.max(dp.get(num),val));
        }
        return dp.get(num);
    }

    public int integerBreakDP(int n) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(1,1);
        for(int i = 2; i <= n; i++) {
            dp.put(i,(i==n) ? 0: i);
            for(int j = 1; j < i; j++) {
                int val = dp.get(j) * dp.get(i-j);
                dp.put(i, Math.max(dp.get(i),val));
            }
        }
        return dp.get(n);
    }
}
