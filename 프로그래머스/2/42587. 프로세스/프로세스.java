import java.util.*;

class Solution {

    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<priorities.length; i++){
            queue.offer(new int[]{i, priorities[i]});
            pq.offer(priorities[i]);
        }
        
        int order = 1;
        int answer = -1;
        while(!queue.isEmpty()){
            int[] tem = queue.poll();
            if(tem[1]<pq.peek()){
                queue.offer(tem);
            }
            else{
                if(tem[0]==location){
                    answer = order;
                    break;
                }
                pq.poll();
                order++;
            }
        }
        return answer;
    }
}