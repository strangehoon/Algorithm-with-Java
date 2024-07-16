import java.util.*;
class Solution {
    public List<List<Integer>> graph = new ArrayList<>();
    public int cnt;
    public boolean[] visited;
    public void DFS(int idx){
        
        for(int n : graph.get(idx)){
            if(!visited[n]){
                visited[n] = true;
                DFS(n);
                cnt++;
            }
        }
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for(int i=0; i<wires.length; i++){
            cnt = 1;
            int a = wires[i][0];
            int b = wires[i][1];
            visited = new boolean[n+1];
            graph.get(a).remove(Integer.valueOf(b));
            graph.get(b).remove(Integer.valueOf(a));
            visited[a] = true;
            DFS(a);
            graph.get(a).add(Integer.valueOf(b));
            graph.get(b).add(Integer.valueOf(a));
            int tem = Math.abs(cnt - (n-cnt));
            answer = Math.min(answer, tem);
        }
        
        return answer;
    }
}