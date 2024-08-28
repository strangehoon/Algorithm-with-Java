import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int mok = s/n;
        int rest = s%n;
        
        if(mok==0){
            answer = new int[1];
            answer[0] = -1;
        }
        else{
            for(int i=0; i<n; i++){
                answer[i] = mok;
                if(rest>0){
                    answer[i] += 1;
                    rest--;
                }
            }
        }
        Arrays.sort(answer);
        return answer;
    }
}