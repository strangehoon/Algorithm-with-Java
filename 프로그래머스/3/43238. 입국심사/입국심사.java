class Solution {
    public long solution(int n, int[] times) {
        
        long idx = 0l;
        long jdx = 1000000000000000000l;
        long answer = Long.MAX_VALUE;
        while(idx<=jdx){
            long mid = (idx+jdx)/2;
            long std = 0;
            for(int i=0; i<times.length; i++){
                std += mid/times[i];
            }
            
            if(n<=std){
                jdx = mid-1;
                answer = Math.min(answer, mid);
            }
            else if(n > std){
                idx = mid+1;
            }
        }

        return answer;
    }
}