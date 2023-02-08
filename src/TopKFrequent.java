import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {

    public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue() - b.getValue()
        );
        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            pq.add(entry);
            if(pq.size() > k) pq.poll();
        }
        int i = k;
        while(!pq.isEmpty()) {
            res[--i] = pq.poll().getKey();
        }
        return res;
    }
    public static void main(String[] args) {
        int[] list = {1,1,1,3,2,2};
        int[] res = topKFrequent(list,2);
        System.out.println(res[0]+" "+res[1]);
    }
}
