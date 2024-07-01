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
        public int compareTo(Edge e){
            return e.cost - this.cost;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        int X = Integer.valueOf(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        List<List<Edge>> reverseGraph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            int t = Integer.valueOf(st.nextToken());
            graph.get(a).add(new Edge(b, t));
            reverseGraph.get(b).add(new Edge(a, t));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        PriorityQueue<Edge> reversePq = new PriorityQueue<>();
        pq.offer(new Edge(X, 0));
        reversePq.offer(new Edge(X, 0));
        int[] dist = new int[N+1];
        int[] reverseDist = new int[N+1];
        for(int i=1; i<=N; i++){
            dist[i] = Integer.MAX_VALUE;
            reverseDist[i] = Integer.MAX_VALUE;
        }
        dist[X] = 0;
        reverseDist[X] = 0;

        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int now = edge.vertex;
            int nowCost = edge.cost;
            if(dist[now]<nowCost)
                continue;
            for(Edge tem : graph.get(now)){
                if(dist[tem.vertex]>dist[now]+tem.cost){
                    dist[tem.vertex] = dist[now] + tem.cost;
                    pq.offer(new Edge(tem.vertex, dist[tem.vertex]));
                }
            }
        }
        while(!reversePq.isEmpty()){
            Edge edge = reversePq.poll();
            int now = edge.vertex;
            int nowCost = edge.cost;
            if(reverseDist[now]<nowCost)
                continue;
            for(Edge tem : reverseGraph.get(now)){
                if(reverseDist[tem.vertex]>reverseDist[now]+tem.cost){
                    reverseDist[tem.vertex] = reverseDist[now] + tem.cost;
                    reversePq.offer(new Edge(tem.vertex, reverseDist[tem.vertex]));
                }
            }
        }
        int result = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++){
            int tem = dist[i] + reverseDist[i];
            result = Math.max(result, tem);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}