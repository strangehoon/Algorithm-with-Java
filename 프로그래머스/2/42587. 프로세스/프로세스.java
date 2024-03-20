import java.util.*;
class Solution {
    public class Process {
        int priority;
        int loc;
        
        public Process(int priority, int loc){
            this.priority = priority;
            this.loc = loc;
        }
    }
    public int solution(int[] priorities, int location) {
        Queue<Process> queue = new LinkedList<>();
        for(int i=0; i<priorities.length; i++){
            queue.offer(new Process(priorities[i], i));
        }
        int cnt = 1;
        while(!queue.isEmpty()){
            Process nowProc = queue.poll();
            boolean flag = true;
            int size = queue.size();
            while(size-->0){
                Process temProc = queue.poll();
                if(temProc.priority > nowProc.priority){
                    flag = false;
                }
                queue.offer(temProc);
            }
            if(flag==false){
                queue.offer(nowProc);
            }
            else if(flag==true && nowProc.loc==location){
                return cnt;
            }
            else if(flag==true){
                cnt++;
            }
        }
    
        return cnt;
    }
}