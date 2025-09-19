class Solution {
    public int[] solution(int[] sequence, int k) {
        int len = sequence.length;
        
        int sum = 0;
        int j = 0;
        int seqLen = Integer.MAX_VALUE;
        int[] answer = new int[2];
        for(int i=0; i<len; i++){
            sum += sequence[i];
            
            while(sum > k){
                sum -= sequence[j++];     
            }
            
            if(sum==k & seqLen>i-j){
                answer[0] = j;
                answer[1] = i;
                seqLen = i-j;
            }
        }
        
        
        return answer;
    }
}