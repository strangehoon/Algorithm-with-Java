import java.util.*;
// 2026-03-07
// 20:50 ~ 21:10

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
    
        long idx = 1;
        long jdx = 1000000000000000000l;
        
        while(idx<=jdx){
            long mid = (idx+jdx)/2;
            long cnt = 0;
            for(int time : times){
                cnt += mid/time;
            }
            
            if(cnt>=n){
                answer = Math.min(answer, mid);
                jdx = mid-1;
            }
            else{
                idx = mid+1;
            }
        }
        
        return answer;
    }
}