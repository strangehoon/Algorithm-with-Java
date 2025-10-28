import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<priorities.length; i++){
            queue.offer(new int[]{i, priorities[i]});
        }
        
        List<Integer> answer = new LinkedList<>();
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            int size = queue.size();
            boolean flag = true;
            while(size-->0){
                int[] next = queue.poll();
                if(next[1]>cur[1]){
                    flag=false;
                }
                queue.offer(next);
            }
            if(flag){
                answer.add(cur[0]);
            }
            else{
                queue.offer(cur);
            }
        }
        
        return answer.indexOf(location)+1;
    }
}