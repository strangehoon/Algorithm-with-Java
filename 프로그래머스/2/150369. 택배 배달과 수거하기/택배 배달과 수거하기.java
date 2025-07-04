import java.util.*;

class Solution {
    
    class Delivery implements Comparable<Delivery>{
        int distance;
        int cnt;
        
        public Delivery(int distance, int cnt){
            this.distance = distance;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo(Delivery delivery){
            return delivery.distance-this.distance;
        }
    }
    
    class Pickup implements Comparable<Pickup>{
        int distance;
        int cnt;
        
        public Pickup(int distance, int cnt){
            this.distance = distance;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo(Pickup pickup){
            return pickup.distance-this.distance;
        }
    }
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        
        PriorityQueue<Delivery> deliveryPq = new PriorityQueue<>();
        PriorityQueue<Pickup> pickupPq = new PriorityQueue<>();
        
        int len = deliveries.length;
        for(int i=0; i<len; i++){
            if(deliveries[i]!=0){
                deliveryPq.offer(new Delivery(i+1, deliveries[i]));
            }
            if(pickups[i]!=0){
                pickupPq.offer(new Pickup(i+1, pickups[i]));
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
                Delivery curDelivery = deliveryPq.poll();
                remainDelivery -= curDelivery.cnt;
                
                if(remainDelivery==0)
                    break;
                
                else if(remainDelivery<0){
                    deliveryPq.offer(new Delivery(curDelivery.distance, remainDelivery*-1));
                    break;
                }
            }
            
            while(remainPickup>0 && !pickupPq.isEmpty()){
                Pickup curPickup = pickupPq.poll();
                remainPickup -= curPickup.cnt;
                
                if(remainPickup==0)
                    break;
                
                if(remainPickup<0){
                    pickupPq.offer(new Pickup(curPickup.distance, remainPickup*-1));
                    break;
                }
            }
        }
        
        return answer;
    }
}