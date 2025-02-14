package org.neetcode.graph;

public class FindTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] incoming = new int[n+1];
        int[] outgoing = new int[n+1];
        for(int[] t: trust) {
            outgoing[t[0]]++;
            incoming[t[1]]++;
        }
        for(int i = 1; i <= n; i++) {
            if(incoming[i] == n-1 && outgoing[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 2;
        int[][] trust = {{1,2}};
    }
}
