import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x : scoville){
            pq.offer(x);
        }
        int result = 0;
        while(true){
            Integer first = pq.poll();
            Integer second = pq.poll();
            if(first < K && second==null){
                result = -1;
                break;
            }
            else if(first >= K && second==null){
                break;
            }
            else if(first >= K && second >= K){
                break;
            }
            else {
                pq.offer(first + second*2);
                result ++;
            }
        }
        return result;
    }
}