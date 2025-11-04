import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(truck_weights[0]);
        int seconds = 1;
        int bridge_weight = truck_weights[0];
        int idx=1;
        while(idx<truck_weights.length){
            if(queue.size()==bridge_length){
                int tmp = queue.poll();
                bridge_weight -= tmp;
            }
            
            if(truck_weights[idx]+bridge_weight<=weight){
                queue.offer(truck_weights[idx]);
                bridge_weight += truck_weights[idx];
                idx++;
            }
            else{
                queue.offer(0);
            }
            seconds++;
        }
        seconds += bridge_length;
        return seconds;
    }
}   