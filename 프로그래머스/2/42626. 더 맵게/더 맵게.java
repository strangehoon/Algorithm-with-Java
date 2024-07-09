import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int result = -1;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int num : scoville){
            pq.offer(Long.valueOf(num));
        }
        int num = 0;
        while(pq.size()>0){
            if(pq.size()==1){
                if(pq.poll()>=K)
                    result = num;
                else
                    break;
            }
            else{
                Long first = pq.poll();
                Long second = pq.poll();
                if(first>=K && second>=K){
                    result = num;
                    break;
                }
                else
                    pq.offer(first+second*2);
                num++;    
            }
        }
        return result;
    }
}