import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
    
        for(int h=citations.length; h>=0; h--){
            int cnt = 0;
            for(int i=0; i<citations.length; i++){
                if(citations[i]>=h){
                    cnt++;
                    if(cnt>=h){
                        return h;
                    }
                }
            }
        }
        return -1;
    }
}