import java.util.*;
// 20:55
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        
        Arrays.sort(rocks);
        int[] arr = new int[rocks.length+1];
        arr[0] = rocks[0] - 0;
        for(int i=1; i<arr.length-1; i++){
            arr[i] = rocks[i]-rocks[i-1];
        }
        arr[arr.length-1] = distance-rocks[rocks.length-1];
                
        int lt = 1;
        int rt = 1000000000;
        int answer = 0;
     //   2   11   14   17   21  
        while(lt<rt){
            int mid = (lt+rt)/2;
            
            int pre = 0;
            int cnt = 0;
            for(int i =0; i<rocks.length; i++){
                if(rocks[i] - pre < mid){
                    cnt ++;
                }
                else{
                    pre = rocks[i];
                }
            }
            
            if(distance - pre < mid){
                cnt++;
            }
            
            if(cnt <= n){
                lt = mid+1;
                answer = Math.max(lt, answer);
            }
            else{
                rt = mid-1;
            }
        }
        return answer;
    }
}
 // 0   2   11   14   17   21   25
 //   2   9    3    3    4    4

 // 0    2    11   13   15   17     20  21  22   24    25 
 //    2    9    2    2    2    3      1   1    2    1