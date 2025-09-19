// 20:20
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


// 모든 원소의 합은 1억 이하의 자연수이다.
// 1) 완전 탐색 X
// 2) 
    
// n=2
// dp: 1 1 2
// S : 1 2 3 4 5 6 7 8 9 10 11 12 13 14
    
// dp[i][j] =
    
// for(int i=0; i<n; i++){
//     for(int j=0; j<s; j++){
//         for(int k=1; k<10; k++){
//             dp[i][j] = Math.max(dp[i-1][k-1]*k, dp[i][j]);
//         }
//     }
//