import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        
        if(n>s)
            return new int[]{-1};
        
        int a = s/n;
        int b = s%n;
        
        int[] answer = new int[n];
        Arrays.fill(answer, a);
        
        for(int i=0; i<b; i++){
            answer[n-1-i]++;
        }
        return answer;
    }
}
