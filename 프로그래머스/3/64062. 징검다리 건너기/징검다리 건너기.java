class Solution {
    public int solution(int[] stones, int k) {
        
        int idx = 1;
        int jdx = 200000000;
        int answer = 0;
        while(idx<=jdx){
            int mid = (idx+jdx)/2;
            
            int maxCnt = 0;
            int cnt = 0;
            for(int i=0; i<stones.length; i++){
                if(stones[i]<=mid-1){
                    cnt++;
                    maxCnt = Math.max(cnt, maxCnt);
                }
                else{
                    cnt = 0;
                }
            }
            
            if(maxCnt<k){
                answer = mid;
                idx = mid+1;
            }
            else{
                jdx = mid-1;
            }
        }
        
        return answer;
    }
}
