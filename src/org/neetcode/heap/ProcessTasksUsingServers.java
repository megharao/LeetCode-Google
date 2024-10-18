package org.neetcode.heap;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class ProcessTasksUsingServers {
    public int[] assignTasks(int[] servers, int[] tasks) {
        /**
         * two min heaps, 1 for available servers and 1 for unavailable servers
         * available = (weight, index)
         * unavailable = (timefree, weight, index)
         */
        int[] res = new int[tasks.length];
        PriorityQueue<AvailableServer> availableServers = new PriorityQueue<>((a,b) -> a.weight != b.weight ? (a.weight-b.weight):(a.index-b.index));
        PriorityQueue<UnavailableServer> unavailableServers = new PriorityQueue<>(Comparator.comparingInt(a->a.timeFree));
        for(int i = 0; i < servers.length; i++) {
            availableServers.add(new AvailableServer(servers[i],i));
        }
        int time = 0;
        for(int i = 0; i < tasks.length; i++) {
            time = Math.max(time,i);
            if(availableServers.size()==0) {
                time = unavailableServers.peek().timeFree;
            }
            while (!unavailableServers.isEmpty() && time >= unavailableServers.peek().timeFree) {
                UnavailableServer unavailableServer = unavailableServers.poll();
                availableServers.add(new AvailableServer(unavailableServer.weight,unavailableServer.index));
            }
            AvailableServer availableServer = availableServers.poll();
            res[i] = availableServer.index;
            unavailableServers.add(new UnavailableServer(time+tasks[i],availableServer.weight,availableServer.index));
        }
        return res;
    }
    class AvailableServer {
        int weight;
        int index;
        AvailableServer(int weight, int index) {
            this.weight = weight;
            this.index = index;
        }
    }
    class UnavailableServer{
        int timeFree;
        int weight;
        int index;

        UnavailableServer(int timeFree, int weight, int index) {
            this.timeFree = timeFree;
            this.weight = weight;
            this.index = index;
        }
    }
}
