import java.util.*;
// 2026-02-10
// 12:20 ~ 12:30
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (w1, w2) -> Integer.compare(w2, w1)
        );
        
        for(int work : works){
            pq.offer(work);
        }
        
        while(n-->0 && !pq.isEmpty()){
            int tem = pq.poll();
            if(tem==0){
                break;
            }
            pq.offer(tem-1);
        }
        
        while(!pq.isEmpty()){
            long tem = pq.poll();
            answer += tem*tem;
        }
        
        return answer;
    }
}
