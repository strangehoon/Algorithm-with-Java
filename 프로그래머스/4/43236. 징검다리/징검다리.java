import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        
        Arrays.sort(rocks);
                
        int lt = 1;
        int rt = 1000000000;
        int answer = 0;

        while(lt<=rt){
            int mid = (lt+rt)/2;
            
            int pre = 0;
            int cnt = 0;
            for(int i =0; i<rocks.length; i++){
                if(rocks[i] - pre < mid){
                    cnt ++;
                }
                else{
                    pre = rocks[i];
                }
            }
            
            if(distance - pre < mid){
                cnt++;
            }
            
            if(cnt <= n){
                lt = mid+1;
                answer = mid;
            }
            else{
                rt = mid-1;
            }
        }
        return answer;
    }
}