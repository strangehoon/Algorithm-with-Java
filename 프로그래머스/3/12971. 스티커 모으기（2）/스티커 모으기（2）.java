class Solution {
    public int solution(int stickers[]) {
        int[] dp1 = new int[stickers.length];
        int[] dp2 = new int[stickers.length];
        
        if(stickers.length==1){
            return stickers[0];
        }
        else if(stickers.length==2){
            return Math.max(stickers[0], stickers[1]);
        }
        
        // case1 : 첫번째 스티커 선택
        dp1[0] = stickers[0];
        dp1[1] = stickers[0];
        for(int i=2; i<stickers.length-1; i++){
            dp1[i] = Math.max(dp1[i-2]+stickers[i], dp1[i-1]);
        }
        
        // case1 : 첫번째 스티커 선택 x
        dp2[0] = 0;
        dp2[1] = stickers[1];
        for(int i=2; i<stickers.length; i++){
            dp2[i] = Math.max(dp2[i-2]+stickers[i], dp2[i-1]);
        }
        
        int answer = 0;
        for(int i=0; i<stickers.length; i++){
            answer = Math.max(answer, Math.max(dp1[i], dp2[i]));
        }
        
        return answer;
    }
}
// dp[5] = 26
// dp[6] = 19
// dp[7] = 36

// 3) 맨앞 X, 맨뒤 X
