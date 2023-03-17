package org.neetcode.arrays.hashing;

import java.util.Arrays;
import java.util.List;

public class EncodeDecodeStr {

    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        // write your code here
        StringBuilder stringBuilder = new StringBuilder();
        for(String str: strs) {
            stringBuilder.append(str).append("#");
        }
        return stringBuilder.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
        List<String> strings = Arrays.stream(str.split("#")).toList();
        return strings;
    }
    public static void main(String[] args) {
        List<String> list = Arrays.asList("lint","code","love","you");
        EncodeDecodeStr encodeDecodeStr = new EncodeDecodeStr();
        String encode = encodeDecodeStr.encode(list);
        System.out.println(encode);
        encodeDecodeStr.decode(encode).forEach(System.out::print);
    }
}

