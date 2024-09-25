import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Long jdx = (long)n*1000000000;
        Long idx = 0l;
        Long result = Long.MAX_VALUE;
        while(idx<=jdx){
            Long mid = (idx+jdx)/2;
            Long cnt = 0l;
            for(int time : times){
                cnt += mid/time;
            }
            if(cnt<n){
                idx = mid+1;
            }
            else{
                jdx = mid-1;
                result = Math.min(result, mid);
            }
        }
        
        return result;
    }
}