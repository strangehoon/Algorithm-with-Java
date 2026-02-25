import java.util.*;
// 2026-02-25
// 14:45 ~ 15:00

class Solution {
    public void dfs(int cur, boolean[] visited, List<List<Integer>> graph){
            
        for(int next : graph.get(cur)){
            if(!visited[next]){
                visited[next] = true;
                dfs(next, visited, graph);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<computers.length; i++){
            for(int j=0; j<computers[0].length; j++){
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
                dfs(i, visited, graph);
                answer++;
            }
        }
        return answer;
    }
}