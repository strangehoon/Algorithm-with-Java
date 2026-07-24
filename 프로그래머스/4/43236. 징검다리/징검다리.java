import java.util.*; 
// 17:10 ~ 17:30
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        if(rocks.length<=n){
            return distance;
        }
        
        int lt = 0;
        int rt = distance;
        int answer = 0;
        while(lt<=rt){
            int mid = (lt+rt)/2;
            int std = 0;
            int cnt = 0;
            System.out.println(mid);

            for(int i=0; i<rocks.length; i++){
                if(rocks[i]-std<mid){
                    cnt++;
                }
                else{
                    std = rocks[i];
                }
            }
            
            if(distance-std < mid){
                cnt++;
            }
            
            if(n<cnt){
                rt = mid-1;
            }
            else{
                answer = Math.max(answer, mid);
                lt = mid+1;
            }
        }
        return answer;
    }
}
// 0 2 11 14 17 21 25
// rocks : 2 11 14 17 21    
    

// 1) 바위 사이의 거리들 나열
// -> 2 9 3 3 4 4

// 2) 정답을 기준으로 이분탐색
// -> 
