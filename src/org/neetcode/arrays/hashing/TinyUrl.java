package org.neetcode.arrays.hashing;

import java.util.HashMap;
import java.util.Map;

public class TinyUrl {

    Map<String, String> encodeMap = new HashMap<>();
    Map<String, String> decodeMap = new HashMap<>();
    String base = "http://tinyurl.com";
    public String encode(String longUrl) {
        if(!encodeMap.containsKey(longUrl)) {
            String shortUrl = base + String.valueOf(encodeMap.size() + 1);
            encodeMap.put(longUrl,shortUrl);
            decodeMap.put(shortUrl,longUrl);
        }
        return encodeMap.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decodeMap.get(shortUrl);
    }

    public static void main(String[] args) {

    }
}
