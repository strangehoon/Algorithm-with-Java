import java.util.*;

class Solution {
    public int solution(int[] scovilles, int K) {
        int answer = 0;
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int scoville : scovilles){
            pq.offer((long)scoville);
        }
        
        while(pq.size()>1 && pq.peek() < K){
            long first = pq.poll();
            long second = pq.poll();
            pq.offer(first + second*2);
            answer ++;
        }
        
        if(pq.isEmpty() || pq.peek()<K){
            return -1;
        }
        return answer;
    }
}