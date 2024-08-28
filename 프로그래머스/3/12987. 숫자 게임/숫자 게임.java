import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(A);
        for(int x : B){
            pq.offer(x);
        }
        int idx = 0;
        int result = 0;
        while(!pq.isEmpty()){
            int num = pq.poll();
            if(A[idx]<num){
                result++;
                idx++;
            }
        }
        return result;
    }
}