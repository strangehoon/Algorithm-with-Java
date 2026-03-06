import java.util.*;
// 2026-03-06
// 18:10 ~ 18:30

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int len = Integer.MAX_VALUE;
        
        int right = 0;
        int left = 0;
        int sum = sequence[right];
        
        while(right<sequence.length){
            if(sum<k){
                if(right==sequence.length-1){
                    break;
                }
                else{
                    sum += sequence[++right];    
                }
            }
            else if(sum==k){
                if(len>right-left){
                    len = right-left;
                    answer[0] = left;
                    answer[1] = right;
                }
                sum -= sequence[left++];
            }
            else if(sum>k){
                sum -= sequence[left++];
            }
        }    
        return answer;
    }
}