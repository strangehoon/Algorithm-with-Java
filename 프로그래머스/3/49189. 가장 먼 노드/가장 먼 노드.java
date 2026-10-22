import java.util.*;

class Solution {
    public int solution(int n, int[][] edges) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        
        int[] dists = new int[n+1];
        Arrays.fill(dists, -1);
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        dists[1] = 0;
        
        while(!queue.isEmpty()){
            int now = queue.poll();
            
            for(int next : graph.get(now)){
                if(dists[next]==-1){
                    dists[next] = dists[now]+1;
                    queue.offer(next);
                }
            }
        }
        
        int maxDist = 0;
        int answer = 0;
        for(int dist : dists){
            if(dist > maxDist){
                answer = 1;
                maxDist = dist;
            }
            else if(dist==maxDist){
                answer++;
            }
        }
        return answer;
    }
}