import java.util.*;

class Solution {
    public long solution(int n, int[] works) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Integer i1, Integer i2){
                return i2-i1;
            }
        });
        
        for(int i=0; i<works.length; i++){
            pq.offer(works[i]);
        }
        
        while(n-->0 && !pq.isEmpty()){
            int tem = pq.poll()-1;
            if(tem>0)
                pq.offer(tem);
        }
        
        long answer = 0;
        while(!pq.isEmpty()){
            int num =pq.poll();
            answer += num*num;
        }
    
        return answer;
    }
}