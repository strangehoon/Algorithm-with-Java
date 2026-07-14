import java.util.*;

// 2026-07-14
// 04:50 ~ 05:00

class Solution {
    public long solution(int n, int[] works) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> b-a
        );
        for(int work : works){
            pq.offer(work);
        }
        
        while(n-->0 && !pq.isEmpty()){
            pq.offer(pq.poll()-1);
        }

        long answer = 0;
        if(pq.peek()<=0){
            return 0;
        }
        else{
            while(!pq.isEmpty()){
                answer += Math.pow(pq.poll(), 2);
            }
        }
        
        return answer;
    }
}