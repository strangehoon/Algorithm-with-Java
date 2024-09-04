import java.util.*;
class Solution {
    

    public int solution(int n, int[][] edge) {
        // graph init
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] x : edge){
            graph.get(x[0]).add(x[1]);
            graph.get(x[1]).add(x[0]);
        }
        
        // dist init
        int[] dist = new int[n+1];
        for(int i=1; i<=n; i++){
            dist[i] = -1;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        dist[1] = 0;
        while(!queue.isEmpty()){
            int tem = queue.poll();
            for(int num : graph.get(tem)){
                if(dist[num]==-1){
                    dist[num] = dist[tem]+1;
                    queue.offer(num);
                }
            }
        }
        
        // result
        int max_value = Integer.MIN_VALUE;
        int cnt = 0;
        for(int i=1; i<=n; i++){
            max_value = Math.max(max_value, dist[i]);
        }
        for(int i=1; i<=n; i++){
            if(dist[i]==max_value){
                cnt++;
            }
        }
        return cnt;
    }
}