import java.util.*;

class Solution {

    public int solution(int[][] info, int n, int m) {
        int[][] dp = new int[info.length][m];
        for(int i=0; i<info.length; i++){
            Arrays.fill(dp[i], n);
        }
        if(info[0][0]<n)
            dp[0][0] = info[0][0];
        if(info[0][1]<m)
            dp[0][info[0][1]]=0;
        
        for(int i=1; i<info.length; i++){
            for(int j=0; j<m; j++){
                // a선택
                if(dp[i-1][j]+info[i][0]<n){
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+info[i][0]);
                }
                
                // b선택
                if(j-info[i][1]>=0){
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-info[i][1]]);
                }
            }
        }
        
        int answer = n;
        for(int i=0; i<m; i++){
            answer = Math.min(answer, dp[info.length-1][i]);
        }
        return answer==n ? -1 : answer;   
    }
}