import java.util.*;

class Solution {
    public int solution(int[] scovilles, int K) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int scoville : scovilles){
            pq.offer((long)scoville);
        }
        
        int cnt = 0;
        while(pq.size()>1 && pq.peek()<K){
            long tem = pq.poll() + pq.poll()*2;
            pq.offer(tem);
            cnt++;
        }
        
        if(pq.peek()<K)
            return -1;
        else
            return cnt;
    }
}