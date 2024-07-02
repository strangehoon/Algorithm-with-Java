import java.util.*;
class Solution {
    public class Process{
        int priority;
        int loc;
        public Process(int priority, int loc){
            this.priority = priority;
            this.loc = loc;
        }
    }
    public int solution(int[] priorities, int location) {
        Queue<Process> queue = new LinkedList<>();
        int answer = -1;
        int order = 0;
        for(int i=0; i<priorities.length; i++){
            queue.offer(new Process(priorities[i], i));
        }
        
        while(true){
            Process process = queue.peek();
            int pt = process.priority;
            int size = queue.size();
            boolean flag = true;
            for(int i=0; i<size; i++){
                Process tem = queue.poll();
                int temPt = tem.priority;
                if(temPt>pt){
                    flag = false;
                }
                queue.offer(tem);
            }
            if(flag==true){
                Process dummy = queue.poll();
                order++;
                if(dummy.loc == location){
                    answer = order;
                    break;
                }
            }
            else if(flag==false){
                queue.offer(queue.poll());
            }
        }
        return answer;
    }
}