
import java.util.*;
class Solution {
    
    public int[] parent;
    public class Edge implements Comparable<Edge>{
        int start;
        int end;
        int value;
        
        public Edge(int start, int end, int value){
            this.start = start;
            this.end = end;
            this.value = value;
        }
        
        @Override
        public int compareTo(Edge edge){
            return this.value-edge.value;
        }
    }
    
    public int Find(int x){
        if(parent[x]==x)
            return x;
        else{
            return parent[x] = Find(parent[x]);
        }
    }
    
    public void Union(int a, int b){
        a = Find(a);
        b = Find(b);
        if(a!=b){
            parent[b] = a;
        }
    } 
    
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i=0; i<costs.length; i++){
            pq.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
        }
        int cnt = 0;
        int cost = 0;
        while(cnt<n-1){
            Edge now = pq.poll();
            if(Find(now.start)!=Find(now.end)){
                Union(now.start, now.end);
                cost += now.value;
                cnt++;
            }
        }
    
        return cost;
    }
}