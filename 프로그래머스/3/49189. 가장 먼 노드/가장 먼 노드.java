import java.util.*;

class Solution {
    public int solution(int n, int[][] edges) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        int[] distance = new int[n+1];
        Arrays.fill(distance, -1);
        distance[1] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            for(int next : graph.get(cur)){
                if(distance[next]==-1){
                    distance[next] = distance[cur]+1;
                    queue.offer(next);
                }
            }
        }
        
        int maxDist = 0;
        int cnt = 0;
        for(int i=1; i<=n; i++){
            if(distance[i]>maxDist){
                maxDist = distance[i];
                cnt = 1;
            }
            else if(distance[i]==maxDist){
                cnt ++;
            }
        }
        return cnt;
    }
}