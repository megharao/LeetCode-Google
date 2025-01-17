package org.neetcode.two.pointers;

public class KthSymbolInGrammar {
    public static int kthGrammar(int n, int k) {
        int curr = 0;
        int left = 1, right = (int) Math.pow(2,n-1);
        for(int i = 2; i <= n; i++) {
            int mid = (left+right) / 2;
            if(k <= mid) { //left half
                right = mid;
            } else {
                left = mid+1;
                curr = curr == 0 ? 1: 0;
            }
        }
        return curr;
    }

    public static void main(String[] args) {
        int n = 1, k = 1;
        System.out.println(kthGrammar(n,k));
    }
}
