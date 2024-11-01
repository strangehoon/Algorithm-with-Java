import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        
        int idx = 1;
        int jdx = 200000000;
        int result = 0;
        
        while(idx<=jdx){
            int mid = (idx+jdx)/2;
            int cnt = 0;
            boolean flag = true;
            for(int i=0; i<stones.length; i++){
                if(stones[i]<=mid)
                    cnt++;
                else
                    cnt=0;
                
                if(cnt>=k){
                    flag = false;
                    break;
                }
            }
            if(flag){
                idx = mid+1;
                result = Math.max(result, mid);
            }
            else{
                jdx = mid-1;
            }
        }
        return result+1;
    }
}