package org.neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();
        dfs(0, s, res, part);
        return res;
    }

    public void dfs(int i, String s, List<List<String>> res, List<String> part) {
        if(i >= s.length()) {
            res.add(List.copyOf(part));
            return;
        }
        for(int j = i; j < s.length(); j++) {
            if(isPali(s,i,j)) {
                part.add(s.substring(i,j+1));
                dfs(j+1, s, res, part);
                part.remove(s.substring(i,j+1));
            }
        }
    }

    public boolean isPali(String s, int i, int j) {
        while(i <= j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        List<List<String>> res = palindromePartitioning.partition("aab");
        for(List<String> r: res) {
            r.stream().forEach(i -> System.out.print(i+" "));
            System.out.println();
        }
    }
}
