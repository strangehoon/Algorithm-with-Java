class Solution {
    public long solution(int n, int[] times) {
        long left = 0l;
        long right = 1000000000000000000l;
        long answer = Long.MAX_VALUE;
        
        while(left<=right){
            long mid = (left+right)/2;
            
            long total = 0;
            for(int time : times){
                total += mid/time;
            }
            
            if(n<=total){
                answer = Math.min(answer, mid);
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return answer;
    }
}