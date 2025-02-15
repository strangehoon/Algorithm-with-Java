import java.util.*;
class Solution {

    public class Target implements Comparable<Target>{
        int start;
        int end;
        
        public Target(int start, int end){
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Target t){
            return this.end-t.end;
        }
    }
    
    public int solution(int[][] targets) {
        PriorityQueue<Target> pq = new PriorityQueue<>();
        for(int i=0, len=targets.length; i<len; i++){
            pq.offer(new Target(targets[i][0], targets[i][1]));
        }
        
        int cnt = 1;
        int std = pq.poll().end;
        
        while(!pq.isEmpty()){
            Target t = pq.poll();
            if(t.start>=std){
                std = t.end;
                cnt++;
            }
        }
        
        return cnt;
    }
}