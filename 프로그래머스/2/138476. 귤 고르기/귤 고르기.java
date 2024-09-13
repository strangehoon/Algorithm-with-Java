import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int tan : tangerine){
            map.put(tan, map.getOrDefault(tan, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(Integer key : map.keySet()){
            pq.offer(map.get(key));
        }
        int cnt = 0;
        while(k>0){
            int num = pq.poll();
            k-=num;
            cnt++;
        }
        
        return cnt;
    }
}