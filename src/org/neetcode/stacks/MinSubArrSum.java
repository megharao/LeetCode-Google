package org.neetcode.stacks;

import lombok.Getter;

import java.util.List;
import java.util.Stack;

public class MinSubArrSum {
    public static int sumSubarrayMins(int[] arr) {
        int res = 0;
        Stack<String> stack = new Stack<>();//index#num
        int mod = 1000000007;
        for(int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[i] < Integer.parseInt(stack.peek().split("#")[1])) {
                String s = stack.pop();
                int j = Integer.parseInt(s.split("#")[0]);
                int m = Integer.parseInt(s.split("#")[1]);
                int left = !stack.isEmpty() ?
                        j - Integer.parseInt(stack.peek().split("#")[0]) :
                        j + 1;
                int right = i-j;
                res = ((res + m * left*right) % mod);
            }
            stack.push(i + "#" + arr[i]);
        }
        List<String> list = stack.stream().toList();
        for(int i = 0; i < list.size(); i++) {
            int j = Integer.parseInt(list.get(i).split("#")[0]);
            int n = Integer.parseInt(list.get(i).split("#")[1]);
            int left = i > 0 ? j - Integer.parseInt(list.get(i-1).split("#")[0]) : j + 1;
            int right = arr.length - j;
            res = ((res + n * left * right) % mod);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        System.out.println(sumSubarrayMins(arr));
    }
}
