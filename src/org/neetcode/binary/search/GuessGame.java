package org.neetcode.binary.search;

public class GuessGame {
    public int guessNumber(int n) {
        int low = 0, high = n;
        while(true) {
            int mid = low+(high-low)/2;
            if(guess(mid) == -1) {
                high = mid-1;
            } else if(guess(mid) == 1) {
                low = mid+1;
            } else {
                return mid;
            }
        }
    }

    public int guess(int num) {
        int pick = 1;
        if(num > pick) {
            return -1;
        } else if(num < pick) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        GuessGame guessGame = new GuessGame();
        System.out.println(guessGame.guessNumber(1));
    }
}
