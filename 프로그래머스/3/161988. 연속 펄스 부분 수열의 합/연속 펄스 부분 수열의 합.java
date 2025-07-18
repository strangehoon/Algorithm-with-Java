class Solution {
    public long solution(int[] sequence) {
        
        int len = sequence.length;

        long[] dp1 = new long[len];
        long[] dp2 = new long[len];
        
        dp1[0] = sequence[0];
        dp2[0] = -sequence[0];
        
        long answer = Math.max(dp1[0], dp2[0]);
        
        for(int i=1; i<len; i++){
            long pulse1 = sequence[i]*((i%2==0) ? 1 : -1);
            long pulse2 = sequence[i]*((i%2==1) ? 1 : -1);
            
            dp1[i] = Math.max(dp1[i-1] + pulse1, pulse1);
            dp2[i] = Math.max(dp2[i-1] + pulse2, pulse2);
            
            answer = Math.max(answer, Math.max(dp1[i], dp2[i]));
        }
        return answer;
    }
}