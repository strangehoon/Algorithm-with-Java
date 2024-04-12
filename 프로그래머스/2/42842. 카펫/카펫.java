import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i=1; i<= Math.sqrt(yellow); i++){
            int length = i;
            int wide = yellow/i;
            if((length+2)*(wide+2)-yellow==brown){
                answer[0] = wide+2;
                answer[1] = length+2;
            }
        }
    
        return answer;
    }
}