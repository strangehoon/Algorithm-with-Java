import java.util.*;
class Solution {
    public class Job implements Comparable<Job>{
        int start;
        int time;
        
        public Job(int start, int time){
            this.start = start;
            this.time = time;
        }

        @Override
        public int compareTo(Job j){
            return this.time - j.time;
        }
    }
    public int solution(int[][] jobs) {
        PriorityQueue<Job> pq = new PriorityQueue<>();
        for(int[] job : jobs){
            pq.offer(new Job(job[0], job[1]));
        }
        int cur = 0;
        List<Integer> result = new ArrayList<>();
        List<Job> dummy = new ArrayList<Job>();
        while(true){
            Job tem = pq.poll();
            if(tem==null){
                if(dummy.size()==0){
                    break;
                }    
                else{
                    dummy.sort(new Comparator<Job>() {
                        @Override
                        public int compare(Job j1, Job j2){
                            if(j1.start!=j2.start){
                                return j1.start - j2.start;
                            }
                            else{
                                return j1.time - j2.time;
                            }
                        }
                    });
                    Job y = dummy.get(0);
                    cur = y.start + y.time;
                    result.add(y.time);
                    for(int i=0; i<dummy.size(); i++){
                        if(i==0)
                            continue;
                        pq.offer(dummy.get(i));
                    }
                    dummy.clear();   
                }
            }
            else{
                if(tem.start>cur){
                    dummy.add(tem);
                }
                else{
                    cur += tem.time;
                    result.add(cur-tem.start);
                    for(Job x : dummy){
                        pq.offer(x);
                    }
                    dummy.clear();    
                }
            }    
        }
        int avg;
        int sum = 0;
        for(int x : result){
            sum += x;
        }
        avg = sum/jobs.length;
        return avg;
    }
}