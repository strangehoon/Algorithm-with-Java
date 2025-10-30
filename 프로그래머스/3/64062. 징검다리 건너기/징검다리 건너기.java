// 20:45
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
// 0 : 2 4 5 3 2 1 4 2 5 1
// 1 : 1 3 4 2 1 0 3 1 4 0
// 2 : 0 2 3 1 0 0 2 0 3 0
// 3 : 0 1 2 0 0 0 1 0 2 0
// 4 : X

// if x명이 건너려면
// x-1보다 작거나 같은 원소들이 최대 연속 몇개인지 확인
// 만약에 k보다 작으면 건널 수 있음



// // 완전탐색으로 접근하면 안됨
