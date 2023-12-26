package org.neetcode.arrays.hashing;

public class Flowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n > flowerbed.length) {
            return false;
        }
        for(int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 0) {
                if(((i-1 >= 0 && flowerbed[i-1] == 0 ) || i==0) && ((i+1 < flowerbed.length && flowerbed[i+1] == 0) || i+1 == flowerbed.length)) {
                    flowerbed[i] = 1;
                    n--;
                    if(n == 0) {
                        return true;
                    }
                }
            }
        }
        return n == 0;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,0,1};
        Flowers flowers = new Flowers();
        System.out.println(flowers.canPlaceFlowers(arr,1));
    }
}
