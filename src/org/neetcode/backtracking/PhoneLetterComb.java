package org.neetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneLetterComb {
    public List<String> letterCombinations(String dig) {
        List<String> res = new ArrayList<>();
        Map<String, String> digits = new HashMap<>();
        digits.put("2", "abc");
        digits.put("3", "def");
        digits.put("4", "ghi");
        digits.put("5", "jkl");
        digits.put("6", "mno");
        digits.put("7", "pqrs");
        digits.put("8", "tuv");
        digits.put("9", "wxyz");
        dfs(0, "", dig, digits, res);
        return res;
    }

    public void dfs(int i, String curr, String dig, Map<String, String> digits, List<String> res) {
        if(curr.length() == dig.length()) {
            res.add(curr);
            return;
        }
        String a = String.valueOf(dig.charAt(i));
        for(char c: digits.get(a).toCharArray()) {
            String s = String.valueOf(c);
            dfs(i+1, curr+s, dig, digits, res);
        }
    }

    public static void main(String[] args) {
        PhoneLetterComb phoneLetterComb = new PhoneLetterComb();
        phoneLetterComb.letterCombinations("23").stream().forEach(i -> System.out.println(i+" "));
    }


}
