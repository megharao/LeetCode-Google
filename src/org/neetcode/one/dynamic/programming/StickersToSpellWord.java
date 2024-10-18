package org.neetcode.one.dynamic.programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StickersToSpellWord {
    List<HashMap<Character, Integer>> stickCount;
    public int minStickers(String[] stickers, String target) {
        stickCount = new ArrayList<>();
        for(int i = 0; i < stickers.length; i++) {
            stickCount.add(new HashMap<>());
            for(char c: stickers[i].toCharArray()) {
                stickCount.get(i).put(c,1+stickCount.get(i).getOrDefault(c,0));
            }
        }
        Map<String, Integer> dp = new HashMap<>(); //subseq of target -> min stickers
        int res = dfs(target,new HashMap<>(),dp);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int dfs(String target, Map<Character,Integer> sticker, Map<String, Integer> dp) {
        if(dp.containsKey(target)) {
            return dp.get(target);
        }
        int res = !sticker.isEmpty() ? 1: 0;
        String remainingTarget = "";
        for(char c: target.toCharArray()) {
            if(sticker.containsKey(c) && sticker.get(c) > 0) {
                sticker.put(c,sticker.get(c)-1);
            } else {
                remainingTarget += c;
            }
        }
        if(!remainingTarget.isEmpty()) {
            int used = Integer.MAX_VALUE;
            for(Map<Character,Integer> stick : stickCount) {
                if(!stick.containsKey(remainingTarget.charAt(0))) {
                    continue;
                }
                used = Math.min(used, dfs(remainingTarget,new HashMap<>(stick),dp));
            }
            dp.put(remainingTarget,used);
            res += used;
        }
        return res != Integer.MAX_VALUE+1 ? res : Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        String[] stickers = {"notice","possible"};
        String target = "basicbasic";
        StickersToSpellWord stickersToSpellWord = new StickersToSpellWord();
        System.out.println(stickersToSpellWord.minStickers(stickers,target));
    }
}
