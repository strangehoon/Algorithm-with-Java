import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int len = triangle.length;
        int[][] dp = new int[len][len+1];
        dp[0][0] = triangle[0][0];
        for(int i=0; i<len-1; i++){
            for(int j=0; j<=i; j++){
                dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]+triangle[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j]+triangle[i+1][j+1]);
            }
        }
        
        int max_value = Integer.MIN_VALUE;
        for(int i=0; i<=len; i++){
            max_value = Math.max(max_value, dp[len-1][i]);
        }
        return max_value;
    }
}