class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        int lt = 1;
        int rt = 300000;
        int answer = 300000;
        
        while(lt<=rt){
            int level = (lt+rt)/2;
            long totalTime = 0;
            for(int i=0; i<diffs.length; i++){
                if(diffs[i]<=level || i==0){
                    totalTime += times[i];
                }
                else{
                    totalTime +=  (diffs[i]-level)*(times[i]+times[i-1])+times[i];
                }
            }
            
            if(totalTime>limit){
                lt = level+1;
            }
            else{
                rt = level-1;
                answer = Math.min(answer, level);
            }
        }
        
        return answer;
        
    }
}