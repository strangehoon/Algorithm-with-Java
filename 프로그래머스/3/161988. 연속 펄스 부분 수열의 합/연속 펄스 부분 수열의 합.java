class Solution {
    public long solution(int[] sequence) {
        
        long[] dp1 = new long[sequence.length];
        long[] dp2 = new long[sequence.length];
        dp1[0] = sequence[0];
        dp2[0] = sequence[0]*-1;
        long answer = Math.max(dp1[0], dp2[0]);
        for(int i=1; i<sequence.length; i++){
            int seq1 = i %2 ==0 ? sequence[i] : sequence[i]*-1;
            int seq2 = i %2 ==0 ? sequence[i]*-1 : sequence[i];
            
            dp1[i] = Math.max(dp1[i-1]+seq1, seq1);
            dp2[i] = Math.max(dp2[i-1]+seq2, seq2);
            answer = Math.max(answer, Math.max(dp1[i], dp2[i]));
        }
        return answer;
    }
}