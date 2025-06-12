class Solution {
    public long solution(int[] sequence) {
        
        int len = sequence.length;
        long[] purse1 = new long[len];
        long[] purse2 = new long[len];
        
        for(int i=0; i<len; i++){
            purse1[i] = sequence[i]*((i%2==0) ? 1 : -1);
            purse2[i] = sequence[i]*((i%2==1) ? 1 : -1);
        }
        
        long[] dp1 = new long[len];
        long[] dp2 = new long[len];
        
        dp1[0] = purse1[0];
        dp2[0] = purse2[0];
        
        long result = Math.max(dp1[0], dp2[0]);
        for(int i=1; i<len; i++){
            dp1[i] = Math.max(dp1[i-1] + purse1[i], purse1[i]);
            dp2[i] = Math.max(dp2[i-1] + purse2[i], purse2[i]);
            result = Math.max(result, dp1[i]);
            result = Math.max(result, dp2[i]);
        }
        
        return result;
    }
}