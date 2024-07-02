import java.util.*;
class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<progresses.length; i++){
            int tem = (100-progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i]!=0){
                tem++;
            }
            queue.offer(tem);
        }
        int s = queue.poll();
        int d = 1;
        while(!queue.isEmpty()){
            int tem = queue.poll();
            if(s>=tem){
                d++;
            }
            else{
                answer.add(d);
                s = tem;
                d = 1;
            }
        }
        answer.add(d);
        return answer;
    }
}