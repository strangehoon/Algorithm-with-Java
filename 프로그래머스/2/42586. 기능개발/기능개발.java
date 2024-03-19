import java.util.*;
class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<progresses.length; i++){
            int x = (100-progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i]!=0)
                x++;
            queue.offer(x);
        }
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int x = queue.poll();
            int cnt = 1;
            while(!queue.isEmpty()){
                if(queue.peek()<=x){
                    queue.poll();
                    cnt++;
                }
                else{
                    break;
                }
            }
            result.add(cnt);
        }
        
        return result;
    }
}