package org.neetcode.advanced.graphs;

import java.util.*;
import java.util.stream.Collectors;

public class Itinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets, Comparator.comparing((List<String> list) -> list.get(0))
                .thenComparing(list -> list.get(1)));
        Map<String, List<String>> adj = new HashMap<>();
        for(List<String> t : tickets) {
            if(adj.containsKey(t.get(0))) {
                adj.get(t.get(0)).add(t.get(1));
            } else {
                adj.put(t.get(0), new ArrayList<>());
                adj.get(t.get(0)).add(t.get(1));
            }
        }
        List<String> res = new ArrayList<>();
        res.add("JFK");
        dfs("JFK", res, tickets.size(), adj);
        return res;
    }

    public boolean dfs(String source,List<String> res, int ticketSize,Map<String, List<String>> adj) {
        if(res.size() == ticketSize+1) {
            return true;
        }
        if(!adj.containsKey(source)) {
            return false;
        }
        List<String> temp = new ArrayList<>();
        temp.addAll(adj.get(source));
        for(int i = 0; i < temp.size(); i++) {
            adj.get(source).remove(i);
            res.add(temp.get(i));
            if (dfs(temp.get(i), res, ticketSize, adj)) {
                return true;
            }
            adj.get(source).add(i, temp.get(i));
            res.remove(temp.get(i));
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<String>> listOfLists = new ArrayList<>();

        listOfLists.add(Arrays.asList("EZE", "TIA"));
        listOfLists.add(Arrays.asList("EZE", "HBA"));
        listOfLists.add(Arrays.asList("AXA", "TIA"));
        listOfLists.add(Arrays.asList("JFK", "AXA"));
        listOfLists.add(Arrays.asList("ANU", "JFK"));
        listOfLists.add(Arrays.asList("ADL", "ANU"));
        listOfLists.add(Arrays.asList("TIA", "AUA"));
        listOfLists.add(Arrays.asList("ANU", "AUA"));
        listOfLists.add(Arrays.asList("ADL", "EZE"));
        listOfLists.add(Arrays.asList("ADL", "EZE"));
        listOfLists.add(Arrays.asList("EZE", "ADL"));
        listOfLists.add(Arrays.asList("AXA", "EZE"));
        listOfLists.add(Arrays.asList("AUA", "AXA"));
        listOfLists.add(Arrays.asList("JFK", "AXA"));
        listOfLists.add(Arrays.asList("AXA", "AUA"));
        listOfLists.add(Arrays.asList("AUA", "ADL"));
        listOfLists.add(Arrays.asList("ANU", "EZE"));
        listOfLists.add(Arrays.asList("TIA", "ADL"));
        listOfLists.add(Arrays.asList("EZE", "ANU"));
        listOfLists.add(Arrays.asList("AUA", "ANU"));
        Itinerary itinerary = new Itinerary();
        System.out.print(itinerary.findItinerary(listOfLists));
    }
}
