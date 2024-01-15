import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static List<List<Edge>> graph;
    static int N;
    static int[] dist;
    public static class Edge implements Comparable<Edge>{
        int vertex;
        int value;
        public Edge(int vertex, int value){
            this.vertex = vertex;
            this.value = value;
        }
        @Override
        public int compareTo(Edge o){
            return this.value-o.value;
        }
    }
    public static void Solution(int v){
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Edge(v, 0));
        while (!priorityQueue.isEmpty()){
            Edge tem = priorityQueue.poll();
            int now = tem.vertex;
            int value = tem.value;
            if(dist[now]<value){
                continue;
            }
            for(Edge edge : graph.get(now)){
                if(dist[edge.vertex]>value+ edge.value){
                    dist[edge.vertex] = value + edge.value;
                    priorityQueue.offer(new Edge(edge.vertex, dist[edge.vertex]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        dist = new int[N+1];
        for(int i=0; i<=N; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        Solution(1);
        bw.write(String.valueOf(dist[N]));
        bw.flush();
        bw.close();
        br.close();
    }
}