package org.neetcode.sliding.window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KClosestElem {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> elem = new ArrayList<>(k);
        int l = 0, r = arr.length-k;
        while(l < r) {
            int m = (l+r)/2;
            if(x - arr[m] > arr[m+k]-x) {
                l = m+1;
            } else {
                r = m;
            }
        }
        for(int i = l; i < l+k; i++) {
            elem.add(arr[i]);
        }
        return elem;
    }

    public static void main(String[] args) {

    }
}
