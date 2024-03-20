import java.util.*;
class Solution {
    public int cnt=0;
    public int n;
    public boolean[] visited;
    public List<List<Integer>> graph;
    
    public void DFS(int tem){
        for(int x : graph.get(tem)){
            if(!visited[x]){
                visited[x] = true;
                DFS(x);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        this.n = n;
        graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(computers[i][j]==1)
                    graph.get(i).add(j);
            }
        }
        
        this.visited = new boolean[n];
        for(int i=0; i<n; i++){
            for(int tem : graph.get(i)){
                if(!visited[tem]){
                    visited[tem]=true;
                    cnt++;
                    DFS(tem);
                }
            }    
        }
        return cnt;
    }
}