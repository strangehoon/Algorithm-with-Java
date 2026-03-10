import java.util.*;
// 2026-03-10
// 10:40 ~ 11:10

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int n = citations.length;
        for(int i=0; i<n; i++){
            int h = n-i;
            if(citations[i]>=h){
                return h;
            }
        }
        return 0;
    }
}