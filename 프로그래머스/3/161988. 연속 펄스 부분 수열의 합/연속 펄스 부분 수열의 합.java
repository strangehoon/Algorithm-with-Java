class Solution {
    public long solution(int[] sequence) {
        
        int[] seq1 = new int[sequence.length];
        int[] seq2 = new int[sequence.length];
        long max_value = 0;
        
        for(int i=0; i<sequence.length; i++){
            seq1[i] = sequence[i];
            seq2[i] = sequence[i];
            if(i%2==0)
                seq1[i] *=-1;
            if(i%2==1)
                seq2[i] *=-1;
        }
        
        long sum1 = 0;
        for(int i=0; i<seq1.length; i++){
            int num = seq1[i];
            if(sum1+num>=0){
                sum1 += num;
                max_value = Math.max(sum1, max_value);
            }
            else{
                sum1 = 0;
            }
        }
        
        long sum2 = 0;
        for(int i=0; i<seq2.length; i++){
            int num = seq2[i];
            if(sum2+num>=0){
                sum2 += num;
                max_value = Math.max(sum2, max_value);
            }
            else{
                sum2 = 0;
            }
        }
    
        return max_value;
    }
}