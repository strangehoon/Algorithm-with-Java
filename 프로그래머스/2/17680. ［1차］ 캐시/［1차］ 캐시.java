import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        Queue<String> queue = new LinkedList<>();
        int result = 0;
        for(int i=0; i<cities.length; i++){
            String city = cities[i].toUpperCase();
            // 캐시에 X
            if(!queue.contains(city)){
                if(queue.size()<cacheSize){
                    queue.offer(city);
                }
                else{
                    if(!queue.isEmpty()){
                        queue.poll();
                        queue.offer(city);
                    }
                }
                result += 5;
            }
            // 캐시에 O
            else{
                queue.remove(city);
                queue.offer(city);
                result += 1;
            }
        }
        return result;
    }
}