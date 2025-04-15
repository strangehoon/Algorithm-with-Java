import java.util.*;

class Solution {
    
    public void dfs(int x, int n, int[][] computers, boolean[] visited){
        visited[x] = true;
        for(int j=0; j<n; j++){
            if(computers[x][j]==1 &&!visited[j]){
                dfs(j, n, computers, visited);
            }
       }
    }
    
    public int solution(int n, int[][] computers) {
        
        boolean[] visited = new boolean[n];
        int cnt = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                cnt++;
                dfs(i, n, computers, visited);
            }
        }
        return cnt;
    }
}