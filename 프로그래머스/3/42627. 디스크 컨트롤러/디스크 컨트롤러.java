import java.util.*;

class Solution {
    
    public class Job{
        int num;
        int start;
        int time;
        
        public Job(int num, int start, int time){
            this.num = num;
            this.start = start;
            this.time = time;
        }
    }
    
    public int solution(int[][] jobs) {
        
        PriorityQueue<Job> pq1 = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Job job1, Job job2){
                return job1.start-job2.start;
            }
        });
        
        for(int i=0; i<jobs.length; i++){
            pq1.offer(new Job(i, jobs[i][0], jobs[i][1]));
        }
        
        PriorityQueue<Job> pq2 = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Job job1, Job job2){
                if(job1.time==job2.time){
                    if(job1.start==job2.start){
                        return job1.num-job2.num;
                    }
                    else{
                        return job1.start-job2.start;
                    }
                }
                else{
                    return job1.time-job2.time;
                }
            }
        });
        
        int time = 0;
        int totalTime = 0;
        int idx = 0;
        while(!(pq1.isEmpty() && pq2.isEmpty())){
            
            while(!pq1.isEmpty()&&pq1.peek().start<=time){
                pq2.offer(pq1.poll());
            }
            
            if(!pq2.isEmpty() && pq2.peek().start<=time){
                Job curJob = pq2.poll();
                time += curJob.time;
                totalTime += time-curJob.start; 
            }
            else{
                time++;
            }
        }
        
        int answer = totalTime/jobs.length;
        return answer;
    }
}