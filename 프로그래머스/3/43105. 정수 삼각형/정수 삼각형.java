import java.util.*;

// 2026/07/13
// 20:35 ~ 21:35
class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        
        for(int i=1; i<n; i++){
            for(int j=0; j<triangle[i].length; j++){
                if(j>0){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]);
                }
                if(j<i){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                }
                dp[i][j] += triangle[i][j];
            }
        }
        
        int answer = 0;
        for(int i=0; i<triangle[n-1].length; i++){
            answer = Math.max(answer, dp[n-1][i]);
        }
        return answer;
    }
}