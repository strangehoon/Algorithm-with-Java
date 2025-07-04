import java.util.*;

class Solution {
    
    class Task implements Comparable<Task>{
        int distance;
        int cnt;
        
        public Task(int distance, int cnt){
            this.distance = distance;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo(Task task){
            return task.distance-this.distance;
        }
    }
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        
        PriorityQueue<Task> deliveryPq = new PriorityQueue<>();
        PriorityQueue<Task> pickupPq = new PriorityQueue<>();
        
        for(int i=0; i<n; i++){
            if(deliveries[i]!=0){
                deliveryPq.offer(new Task(i+1, deliveries[i]));
            }
            if(pickups[i]!=0){
                pickupPq.offer(new Task(i+1, pickups[i]));
            }
        }
        
        long answer = 0;
        while(!deliveryPq.isEmpty() || !pickupPq.isEmpty()){
            
            int remainDelivery = cap;
            int remainPickup = cap;
            int maxDistance = 0;
            
            if(!deliveryPq.isEmpty()){
                maxDistance = Math.max(deliveryPq.peek().distance, maxDistance);
            }
            
            if(!pickupPq.isEmpty()){
                maxDistance = Math.max(pickupPq.peek().distance, maxDistance);
            }
            
            answer += maxDistance*2;
            
            while(remainDelivery>0 && !deliveryPq.isEmpty()){
                Task curTask = deliveryPq.poll();
                remainDelivery -= curTask.cnt;
                
                if(remainDelivery==0)
                    break;
                
                else if(remainDelivery<0){
                    deliveryPq.offer(new Task(curTask.distance, remainDelivery*-1));
                    break;
                }
            }
            
            while(remainPickup>0 && !pickupPq.isEmpty()){
                Task curTask = pickupPq.poll();
                remainPickup -= curTask.cnt;
                
                if(remainPickup==0)
                    break;
                
                if(remainPickup<0){
                    pickupPq.offer(new Task(curTask.distance, remainPickup*-1));
                    break;
                }
            }
        }
        
        return answer;
    }
}
