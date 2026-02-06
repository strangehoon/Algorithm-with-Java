class Solution {
    public int solution(int[][] triangle) {
        
        int answer = triangle[0][0];
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        
        for(int i=1; i<triangle.length; i++){
            for(int j=0; j<triangle[i].length; j++){
                if(j==0){
                    dp[i][j] = Math.max(dp[i][j], triangle[i][j]+dp[i-1][j]);
                }
                else if(j==triangle[i].length-1){
                    dp[i][j] = Math.max(dp[i][j], triangle[i][j]+dp[i-1][j-1]);
                }
                else{
                    dp[i][j] = Math.max(dp[i][j], triangle[i][j]+dp[i-1][j-1]);
                    dp[i][j] = Math.max(dp[i][j], triangle[i][j]+dp[i-1][j]);
                }
                answer = Math.max(answer, dp[i][j]);
            }    
        }
        return answer;
    }
}


