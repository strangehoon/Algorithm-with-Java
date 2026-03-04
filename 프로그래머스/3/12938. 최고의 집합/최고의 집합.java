import java.util.*;
// 2026-03-04
// 11:55 ~ 12:10

class Solution {
    public int[] solution(int n, int s) {
        if(n>s){
            return new int[]{-1};
        }
        int[] answer = new int[n];
        int share = s/n;
        Arrays.fill(answer, share);
        int rest = s%n;
        
        int idx = n-1;
        while(rest-->0){
            answer[idx--]++;
        }
        
        return answer;
    }
}