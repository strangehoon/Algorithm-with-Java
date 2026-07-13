import java.util.*;

// 2026/07/13
// 20:05 ~ 20:15
class Solution {
    
    public void dfs(int cur, List<List<Integer>> graph, boolean[] visited){
        
        for(int next : graph.get(cur)){
            if(!visited[next]){
                visited[next] = true;
                dfs(next, graph, visited);
            }
        }
    } 
    
    public int solution(int n, int[][] computers) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(computers[i][j]==1 && i!=j){
                    graph.get(i+1).add(j+1);
                }
            }
        }
        
        boolean[] visited = new boolean[n+1];
        int answer = 0;
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i, graph, visited);
                answer++;
            }
        }
        return answer;
    }
}
