import java.io.*;
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
        public int compareTo(Edge edge){
            return this.cost - edge.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        int[] dist = new int[V+1];
        for(int i=0; i<V+1; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        List<List<Edge>> graph = new ArrayList<>();
        for(int i=0; i<=V; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
        }

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(K, 0));
        dist[K] = 0;
        while (!priorityQueue.isEmpty()){
            Edge tem = priorityQueue.poll();
            int now = tem.vertex;
            int nowCost = tem.cost;
            if(dist[now]<nowCost) {
                continue;
            }
            for(Edge edge : graph.get(now)){
                if(dist[edge.vertex]>nowCost+ edge.cost){
                    dist[edge.vertex] = nowCost + edge.cost;
                    priorityQueue.offer(new Edge(edge.vertex, dist[edge.vertex]));
                }
            }
        }
        for(int i=1; i<V+1; i++){
            if(dist[i]==Integer.MAX_VALUE){
                bw.write("INF\n");
            }
            else
                bw.write(String.valueOf(dist[i])+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
