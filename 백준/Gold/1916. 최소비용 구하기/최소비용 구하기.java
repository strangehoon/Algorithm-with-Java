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
        public int compareTo(Edge o){
            return cost-o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<List<Edge>> graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        int[] dist = new int[N+1];
        for(int i=1; i<N+1; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Edge(start, 0));

        while (!priorityQueue.isEmpty()){
            Edge tem = priorityQueue.poll();
            int now = tem.vertex;
            int nowCost = tem.cost;
            if(nowCost>dist[now]){
                continue;
            }
            for(Edge edge : graph.get(now)){
                if(dist[edge.vertex]>nowCost+ edge.cost){
                    dist[edge.vertex] = nowCost+ edge.cost;
                    priorityQueue.offer(new Edge(edge.vertex, dist[edge.vertex]));
                }
            }
        }

        bw.write(String.valueOf(dist[end]));
        bw.flush();
        bw.close();
        br.close();
    }
}
