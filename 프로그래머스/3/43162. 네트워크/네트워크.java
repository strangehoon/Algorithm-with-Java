import java.util.*;

class Solution {
    
    public void bfs(int num, boolean[] visited, int[][] computers){
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            for(int i=0; i<computers.length; i++){
                if(computers[cur][i]==1 && !visited[i]){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        
        boolean[] visited = new boolean[n];
        int answer = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i]=true;
                answer ++;
                bfs(i, visited, computers);
            }
        }
        
        return answer;
    }
}