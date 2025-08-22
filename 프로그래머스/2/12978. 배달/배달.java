import java.util.*;

class Solution {

    public class Edge {
        int vertex;
        int value;
        
        public Edge(int vertex, int value){
            this.vertex = vertex;
            this.value = value;
        }
    }
    
    public int solution(int N, int[][] roads, int K) {
        
        List<List<Edge>> graph = new ArrayList<>();
        int[] distances = new int[N+1];
        
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
            distances[i] = Integer.MAX_VALUE;
        }
        distances[1] = 0;
        
        for(int[] road : roads){
            graph.get(road[0]).add(new Edge(road[1], road[2]));
            graph.get(road[1]).add(new Edge(road[0], road[2]));
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>(){
            @Override
            public int compare(Edge e1, Edge e2){
                return e1.value - e2.value;
            }
        });
        
        pq.offer(new Edge(1, 0));
        
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int vertex = edge.vertex;
            int value = edge.value;
            
            if(distances[vertex]<value)
                continue;
            
            for(Edge next : graph.get(vertex)){
                if(distances[next.vertex]>value+next.value){
                    distances[next.vertex] = value+next.value;
                    pq.offer(new Edge(next.vertex, distances[next.vertex]));
                }
            }
        }
        
        int answer = 0;
        for(int i=1; i<=N; i++){
            if(distances[i]<=K)
                answer++;
        }
        
        return answer;
    }
}