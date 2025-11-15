import java.util.*;

class Solution {
    
    public int answer = 0;
    
    public boolean dfs(int num, List<List<Integer>> graph, boolean[] visited){
        
        boolean flag = false;
        for(int next : graph.get(num)){
            if(!visited[next]){
                visited[next] = true;
                if(!dfs(next, graph, visited)){
                    flag = true;
                }
            }
        }
        if(flag)
            answer++;
        return flag;
    }
    
    public int solution(int n, int[][] lighthouses) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] lighthouse : lighthouses){
            graph.get(lighthouse[0]).add(lighthouse[1]);
            graph.get(lighthouse[1]).add(lighthouse[0]);
        }
        
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        dfs(1, graph, visited);
        
        return answer;
    }
}