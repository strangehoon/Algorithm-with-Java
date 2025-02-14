import java.util.*;
class Solution {
    // 7:20 ~ 20:28
    public class Box implements Comparable<Box>{
        int distance;
        int num;
        
        public Box(int distance, int num){
            this.distance = distance;
            this.num = num;
        }
        
        @Override
        public int compareTo(Box b){
            return b.distance-this.distance;
        }
    }
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        
        PriorityQueue<Box> deliveryPq = new PriorityQueue<>();
        PriorityQueue<Box> pickupPq = new PriorityQueue<>();
        
        for(int i=1; i<=n; i++){
            if(deliveries[i-1]!=0)
                deliveryPq.offer(new Box(i, deliveries[i-1]));
            if(pickups[i-1]!=0)
                pickupPq.offer(new Box(i, pickups[i-1]));
        }
        
        long answer = 0;
        while(!deliveryPq.isEmpty() || !pickupPq.isEmpty()){
            int maxDistance = 0;
            if(!deliveryPq.isEmpty()){
                maxDistance = deliveryPq.peek().distance;
            }
            if(!pickupPq.isEmpty()){
                maxDistance = Math.max(maxDistance, pickupPq.peek().distance);
            }

            answer += 2*maxDistance;
            
            int cnt1 = 0;
            while(!deliveryPq.isEmpty() && cnt1<cap){
                if(cap-cnt1 < deliveryPq.peek().num){
                    Box tem = deliveryPq.poll();
                    deliveryPq.offer(new Box(tem.distance, tem.num-(cap-cnt1)));
                    cnt1 += (cap-cnt1);
                }
                else{
                    cnt1 += deliveryPq.poll().num;
                }
            }

            int cnt2 = 0;
            while(!pickupPq.isEmpty() && cnt2<cap){
                if(cap-cnt2 < pickupPq.peek().num){
                    Box tem = pickupPq.poll();
                    pickupPq.offer(new Box(tem.distance, tem.num-(cap-cnt2)));
                    cnt2 += (cap-cnt2);
                }
                else{
                    cnt2 += pickupPq.poll().num;
                }
            } 
        }
        
        return answer;
    }
}