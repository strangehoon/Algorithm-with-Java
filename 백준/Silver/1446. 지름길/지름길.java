import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static List<List<Edge>> graph;
    static int[] dis;
    public static class Edge implements Comparable<Edge>{
        int vertex;
        int value;

        public Edge(int vertex, int value){
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return this.value-o.value;
        }
    }

    public static void solution(int v){
        dis[v] = 0;
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Edge(v, 0));
        while (!priorityQueue.isEmpty()){
            Edge tem = priorityQueue.poll();
            int now = tem.vertex;
            int nowDist = tem.value;
            if(dis[now]<nowDist)
                continue;
            for(Edge edge : graph.get(now)){
                if(dis[edge.vertex]>nowDist+ edge.value){
                    dis[edge.vertex] = nowDist+ edge.value;
                    priorityQueue.offer(new Edge(edge.vertex, dis[edge.vertex]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for(int i=0; i<=D; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            if(end>D)
                continue;
            graph.get(start).add(new Edge(end, len));
        }
        for(int i=0; i<D; i++){
            graph.get(i).add(new Edge(i+1, 1));
        }
        dis = new int[D+1];
        for(int i=0; i<=D; i++){
            dis[i] = Integer.MAX_VALUE;
        }
        solution(0);
        bw.write(String.valueOf(dis[D]));
        bw.flush();
        bw.close();
        br.close();
    }
}