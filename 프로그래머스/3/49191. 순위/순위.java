import java.util.*;

class Solution {
    
    public void bfs(int num, boolean[] visited, List<List<Integer>> graph){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);
        visited[num] = true;
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            for(int next : graph.get(cur)){
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
    
    public int solution(int n, int[][] results) {
        
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> reversedGraph = new ArrayList<>();
        
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
            reversedGraph.add(new ArrayList<>());
        }
        
        for(int[] result : results){
            graph.get(result[0]).add(result[1]);
            reversedGraph.get(result[1]).add(result[0]);   
        }
        
        int[] cnts = new int[n+1];
        
        for(int i=1; i<=n; i++){
            boolean[] visited = new boolean[n+1];
            bfs(i, visited, graph);
            bfs(i, visited, reversedGraph);
            
            int cnt = 0;
            for(int j=1; j<=n; j++){
                if(visited[j])
                    cnt++;
            }
            cnts[i] = cnt;
        }
        
        int answer = 0;
        for(int tem: cnts){
            if(tem==n)
                answer++;
        }
        
        return answer;
    }
}