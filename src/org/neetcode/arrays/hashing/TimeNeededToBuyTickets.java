package org.neetcode.arrays.hashing;

public class TimeNeededToBuyTickets {
    public static int timeRequiredToBuy(int[] tickets, int k) {
        int minTickets = tickets[k];
        int res = 0;
        for(int i =0; i < tickets.length; i++) {
            if(i <= k) {
                res += Math.min(tickets[i], minTickets);
            } else {
                res += Math.min(tickets[i], minTickets-1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] tickets = {5,1,1,1};
        int k = 0;
        System.out.println(timeRequiredToBuy(tickets, k));
    }
}
