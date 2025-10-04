class Solution {
    public int solution(int n, int[] money) {
        
        int[][] dp = new int[money.length+1][n+1];
        
        for(int i=1; i<=money.length; i++){
            dp[i][0] = 1;
        }
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=money.length; j++){
                dp[j][i] = dp[j-1][i];
                if(i-money[j-1]>=0)
                    dp[j][i] += (dp[j][i-money[j-1]])%1000000007;
            }
        }
        
        return dp[money.length][n];
    }
}      

