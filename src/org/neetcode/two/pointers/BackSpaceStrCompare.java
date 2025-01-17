package org.neetcode.two.pointers;

public class BackSpaceStrCompare {
    public static boolean backspaceCompare(String s, String t) {
        int indexS = s.length() - 1, indexT = t.length() - 1;
        while(indexS >= 0 || indexT >= 0) {
            indexS = nextValidChar(s,indexS);
            indexT = nextValidChar(t,indexT);
            char charS = indexS >= 0 ? s.charAt(indexS) : '\0';
            char charT = indexT >= 0 ? t.charAt(indexT) : '\0';
            if(charS != charT) {
                return false;
            }
            indexS--;
            indexT--;
        }
        return true;
    }

    public static int nextValidChar(String s, int index) {
        int backspace = 0;
        while(index >= 0) {
            if(backspace == 0 && s.charAt(index) != '#') {
                break;
            } else if (s.charAt(index) == '#') {
                backspace++;
            } else {
                backspace--;
            }
            index--;
        }
        return index;
    }

    public static void main(String[] args) {
        String s = "ab##", t = "c#d#";
        System.out.println(backspaceCompare(s,t));
    }
}
