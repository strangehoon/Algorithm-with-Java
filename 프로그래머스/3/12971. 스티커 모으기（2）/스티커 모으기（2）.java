class Solution {
    public int solution(int stickers[]) {
        int answer = 0;
        int[][] dp = new int[3][stickers.length];
        
        // case 1 : 맨앞 O, 맨뒤 X
        dp[0][0] = stickers[0];
        dp[0][1] = 0;
        dp[0][2] = stickers[0] + stickers[2];
        for(int i=3; i<stickers.length-1; i++){
            dp[0][i] = Math.max(dp[0][i-2], dp[0][i-3]) + stickers[i];
            answer = Math.max(answer, dp[0][i]);
        }    
        
        // case 2 : 맨앞 X, 맨뒤 O
        dp[1][0] = 0;
        dp[1][1] = stickers[1];
        dp[1][2] = stickers[2];
        for(int i=3; i<stickers.length; i++){
            dp[1][i] = Math.max(dp[1][i-2], dp[1][i-3]) + stickers[i];
            answer = Math.max(answer, dp[1][i]);
        } 
        
        // case 3 : 맨앞 X, 맨뒤 X
        dp[2][0] = 0;
        dp[2][1] = stickers[1];
        dp[2][2] = stickers[2];
        for(int i=3; i<stickers.length-1; i++){
            dp[2][i] = Math.max(dp[2][i-2], dp[2][i-3]) + stickers[i];
            answer = Math.max(answer, dp[2][i]);
        }
        return answer;
    }
}


// 1) 맨앞 O 맨뒤 X 
// 14 6 5 11 3 9 2
// dp[i] = Math.max(dp[i-2], dp[i-3]) + arr[i]
// dp[0] = 14
// dp[1] = 0
// dp[2] = 19

// dp[3] = 25
// dp[4] = 22
// dp[5] = 34

// 2) 맨앞 X 맨뒤 O
// dp[0] = 0
// dp[1] = 6
// dp[2] = 5

// dp[3] = 17
// dp[4] = 9
// dp[5] = 26
// dp[6] = 19
// dp[7] = 36

// 3) 맨앞 X, 맨뒤 X
