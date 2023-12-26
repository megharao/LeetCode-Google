package org.neetcode.binary.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {

    class Pair{
        String value;
        int timestamp;

        Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<Pair>> obj;

    public TimeMap() {
        obj = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(obj.containsKey(key)) {
            List<Pair> list = obj.get(key);
            list.add(new Pair(value,timestamp));
        } else {
            List<Pair> list = new ArrayList<>();
            list.add(new Pair(value,timestamp));
            obj.put(key, list);
        }
    }

    public String get(String key, int timestamp) {
        List<Pair> list = obj.get(key);
        String res = "";
        if(list == null) {
            return res;
        }
        int l = 0, r = list.size()-1;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if(list.get(mid).timestamp <= timestamp) {
                res = list.get(mid).value;
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
        System.out.println(timeMap.get("foo", 1));         // return "bar"
        System.out.println(timeMap.get("foo", 3));         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        System.out.println(timeMap.get("foo", 4));         // return "bar2"
        System.out.println(timeMap.get("foo", 5));         // return "bar2"
    }
}
