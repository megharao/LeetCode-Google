package org.neetcode.binary.search;

import java.util.Arrays;

public class SpellsPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] pairs = new int[spells.length];
        Arrays.sort(potions);

        for(int i = 0; i < spells.length; i++) {
            int count = getCount(spells[i], potions, success);
            pairs[i] = count;
        }
        return pairs;
    }

    public int getCount(int spell, int[] potions, long success) {
        int l = 0, r = potions.length-1;
        int idx = potions.length;
        while(l <= r) {
            int m = l + (r-l)/2;
            if(potions[m]*spell >= success) {
                r = m-1;
                idx = m;
            } else {
                l = m+1;
            }
        }
        return potions.length-idx;
    }

    public static void main(String[] args) {
        SpellsPotions spellsPotions = new SpellsPotions();
        int[] spells = {5,1,3};
        int[] potions = {1,2,3,4,5};
        System.out.println(spellsPotions.successfulPairs(spells,potions,7));
    }
}
