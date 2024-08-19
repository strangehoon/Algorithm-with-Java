import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works){
            pq.offer(work);
        }
        for(int i=0; i<n; i++){
            int tem = pq.poll();
            if(tem==0){
                return 0;
            }
            else{
                pq.offer(tem-1);
            }
        }
        long result = 0;
        for(int tem : pq){
            result += tem*tem;
        }
        
        return result;
    }
}