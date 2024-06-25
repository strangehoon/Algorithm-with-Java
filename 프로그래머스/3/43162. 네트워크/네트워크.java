import java.util.*;
class Solution {
    public int[][] computers;
    public int n;
    public boolean[] visited;
    public int answer = 0;
    
    public void DFS(int idx){    
        visited[idx] = true;
        for(int i=0; i<n; i++){
            if(computers[idx][i]==1 && visited[i]==false){
                DFS(i);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        this.computers = computers;
        this.n = n;
        this.visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                DFS(i);
                answer++;
            }
        }
        return answer;
    }
}