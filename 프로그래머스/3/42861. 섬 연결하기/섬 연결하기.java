import java.util.*;

class Solution {
    
    public int[] arr;

    public int find(int x){
        if(arr[x]==x){
            return x;
        }
        else{
            return arr[x] = find(arr[x]);
        }
    }
    
    public void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            arr[a]=b;  
        }
    }
    
    public class Edge implements Comparable<Edge>{
        int s;
        int e;
        int v;
        
        public Edge(int s, int e, int v){
            this.s = s;
            this.e = e;
            this.v = v;
        }
        
        @Override
        public int compareTo(Edge e){
            return this.v-e.v;
        }
    }
    
    public int solution(int n, int[][] costs) {
        
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = i;
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int[] cost : costs){
            pq.offer(new Edge(cost[0], cost[1], cost[2]));
        }
        
        int cnt = n-1;
        int answer = 0;
        while(cnt>0){
            Edge cur = pq.poll();
            if(find(cur.s)!=find(cur.e)){
                union(cur.s, cur.e);
                answer += cur.v;
                cnt--;
            }
        }
        
        return answer;
    }
}