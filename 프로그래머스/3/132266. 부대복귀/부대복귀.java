import java.util.*;
class Solution {
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<roads.length; i++){
            int[] road = roads[i];
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        
        Queue<Integer> queue = new LinkedList<>();
        
        dist[destination] =0;
        queue.offer(destination);
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            for(int next: graph.get(cur)){
                if(dist[next]==-1){
                    dist[next] = dist[cur]+1;
                    queue.offer(next);
                }
            }
        }
        
        int[] answer = new int[sources.length];
        for(int i=0; i<sources.length; i++){
            answer[i] = dist[sources[i]];
        }
        return answer;
    }
}