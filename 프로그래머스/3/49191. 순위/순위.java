import java.util.*;
// 18:40
class Solution {
    
    public int dfs(int cur, List<List<Integer>> graph, int total, boolean[] visited){
        
        int cnt = 0;
        for(int next : graph.get(cur)){
            if(!visited[next]){
                visited[next] = true;
                cnt += dfs(next, graph, cnt+1, visited);
            }
        }
        return cnt+total;
    }
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> reverseGraph = new ArrayList<>();
        
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }
        
        for(int[] result : results){
            graph.get(result[0]).add(result[1]);
            reverseGraph.get(result[1]).add(result[0]);
        }
        
        int[] cnts = new int[n+1];
        for(int i=1; i<=n; i++){
            boolean[] visited = new boolean[n+1];
            visited[i] = true;
            cnts[i] = dfs(i, graph, 0, visited);
            System.out.println(cnts[i]);
        }
        for(int i=1; i<=n; i++){
            boolean[] visited = new boolean[n+1];
            visited[i] = true;
            cnts[i] = dfs(i, reverseGraph, 0, visited);
            System.out.println(cnts[i]);
        }
        
        return answer;
    }
}

// // 나보다 뒤
// 1 2
// 2 5
// 3 2
// 4 2 3
// 5

// 1 - 2
// 2 - 1
// 3 - 2
// 4 - 3
// 5 - 0



// // 나보다 앞
// 1 
// 2 1 3 4
// 3 4
// 4 
// 5 2
    
// 1 - 0
// 2 - 3
// 3 - 1
// 4 - 0
// 5 - 4
// // 나보다 뒤랑 앞을 합쳐서 n-1이 나와야함
    
// 1 - 2
// 2 - 4
// 3 - 3
// 4 - 3
// 5 - 4