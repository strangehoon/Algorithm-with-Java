import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static class Edge implements Comparable<Edge>{
        int vertex;
        int cost;

        public Edge(int vertex, int cost){
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge E) {
            return this.cost - E.cost;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.valueOf(st.nextToken());
        int E = Integer.valueOf(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int K = Integer.valueOf(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for(int i=0; i<=V; i++){
            graph.add(new ArrayList<>());
        }

        int[] distance = new int[V+1];
        for(int i=0; i<=V; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        for(int i= 0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.valueOf(st.nextToken());
            int v = Integer.valueOf(st.nextToken());
            int w = Integer.valueOf(st.nextToken());
            graph.get(u).add(new Edge(v, w));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(K, 0));
        distance[K] = 0;

        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int now = edge.vertex;
            int nowCost = edge.cost;

            if(distance[now]<nowCost){
                continue;
            }
            for(Edge tem : graph.get(now)){
                if(distance[tem.vertex]>distance[now]+tem.cost){
                    distance[tem.vertex] = distance[now]+tem.cost;
                    pq.offer(new Edge(tem.vertex, distance[tem.vertex]));
                }
            }
        }
        for(int i=1; i<=V; i++){
            if(distance[i]==Integer.MAX_VALUE){
                bw.write(String.valueOf("INF")+"\n");
            }
            else{
                bw.write(String.valueOf(distance[i])+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}