import java.util.*;
// 2026-02-13
// 11:00 ~ 11:12
class Solution {
    public int solution(int n) {
        
        int idx = 0;
        int jdx = 0;
        int sum = 0;
        int answer = 0;
        while(jdx<=n){
            if(sum>=n){
                if(sum==n){
                    answer++;
                }
                idx++;
                sum -= idx;
            }
            else{
                jdx++;
                sum += jdx;
            }
        }
        return answer;
    }
}