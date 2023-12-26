package org.neetcode.arrays.hashing;

public class CheckIfDouble {
    public static boolean checkIfExist(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i] == 2*arr[j] || arr[j] == 2*arr[i])
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,14,11};
        System.out.print(checkIfExist(arr));
    }
}
