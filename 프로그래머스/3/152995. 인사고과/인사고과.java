
// 2026/07/16
// 18:50 ~ 

import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] wanhoScore = new int[]{scores[0][0], scores[0][1]};
        
        // 근무 태도 점수 : 내림차순, 동료 평가 점수 : 오름차순
        Arrays.sort(scores, 
            (a, b) -> {
                if(a[0]==b[0]){
                    return a[1]-b[1];
                }
                else{
                    return b[0]-a[0];
                }
            }   
        );
        
        int std = scores[0][1];
        int[] newArr = new int[scores.length];
        newArr[0] = scores[0][0] + scores[0][1];
        for(int i=1; i<scores.length; i++){
            if(std > scores[i][1]){
                newArr[i] = -1;
                if(scores[i][0]==wanhoScore[0] && scores[i][1]==wanhoScore[1]){
                    return -1;
                }
            }
            else{
                newArr[i] = scores[i][0] + scores[i][1];
                std = scores[i][1];
            }
        }        
        
        Arrays.sort(newArr);
        int rank = 1;
        for(int i=newArr.length-1; i>=0; i--){
            if(newArr[i]==wanhoScore[0]+wanhoScore[1]){
                return rank;
            }
            else{
                rank++;
            }
        }
        return -1;
    }
}


// 1 4
// 2 1
// 2 2
// 3 2
// 3 2

// 첫번째는 내림차순, 두번째는 오름차순
// 3 2    
// 3 2
// 2 1
// 2 2
// 1 4