import java.util.*;
class Solution {
    public class Truck{
        int weight;
        int dist;
        
        public Truck(int weight, int dist){
            this.weight = weight;
            this.dist = dist;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int idx = 0;
        int total_weight = 0;
        Queue<Truck> queue = new LinkedList<>();
        while(true){
            if(idx==truck_weights.length && queue.isEmpty())
                break;
            int size = queue.size();
            while(size-->0){
                Truck truck = queue.poll();
                if(truck.dist==bridge_length){
                    total_weight -= truck.weight;
                }
                else{
                    truck.dist++;
                    queue.offer(truck);
                }
            }
            if(idx<truck_weights.length){
                int tem = truck_weights[idx];
                if(total_weight+tem<=weight){
                    queue.offer(new Truck(tem, 1));
                    total_weight += tem;
                    idx++;
                }
            }
            answer++;
        }
        return answer;
    }
}