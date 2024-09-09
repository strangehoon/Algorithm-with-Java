// 8:40- 9:05 , 2:10
// 왜 dfs로 풀었는데 시간초과 판정이 뜰까...? dp랑 연관이 있을까??? 
// 1)한번 dp + dfs 문제 풀어보자
// 2)BFS로 풀어보자
import java.util.*;
class Solution {
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>>graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<roads.length; i++){
            graph.get(roads[i][0]).add(roads[i][1]);
            graph.get(roads[i][1]).add(roads[i][0]);
        }
        
        int[] result = new int[sources.length];
        int[] dist = new int[n+1];
        for(int j=1; j<=n; j++){
            dist[j] = Integer.MAX_VALUE;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(destination);
        dist[destination] = 0;
        
        while(!queue.isEmpty()){
            int now = queue.poll();
            
            for(int tem : graph.get(now)){
                if(dist[tem]==Integer.MAX_VALUE){
                    dist[tem] = dist[now]+1;
                    queue.offer(tem);
                }
            }
        }
        
        for(int i=0; i<sources.length; i++){
            if(dist[sources[i]]==Integer.MAX_VALUE)
                result[i] = -1;
            else
                result[i] = dist[sources[i]];
        }
        
        return result;
    }
}