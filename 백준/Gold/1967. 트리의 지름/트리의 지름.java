import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static class Edge{
        int vertex;
        int distance;

        public Edge(int vertex, int distance){
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public static List<List<Edge>> graph;
    public static int N;
    public static int[] distance;

    public static void BFS(int x){
        distance = new int[N+1];
        Arrays.fill(distance, -1);

        Queue<Integer> pq = new LinkedList<>();
        pq.offer(x);
        distance[x] = 0;

        while (!pq.isEmpty()){
            int curV = pq.poll();
            for(Edge edge : graph.get(curV)){
                if(distance[edge.vertex]==-1){
                    pq.offer(edge.vertex);
                    distance[edge.vertex] = distance[curV] + edge.distance;
                 }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.valueOf(br.readLine());
        graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            int v = Integer.valueOf(st.nextToken());

            graph.get(a).add(new Edge(b, v));
            graph.get(b).add(new Edge(a, v));
        }

        BFS(1);

        int maxVertex = Integer.MIN_VALUE;
        int maxDistance = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++){
            if(distance[i]>maxDistance){
                maxVertex = i;
                maxDistance = distance[i];
            }
        }

        BFS(maxVertex);
        maxDistance = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++){
            if(distance[i]>maxDistance){
                maxDistance = distance[i];
            }
        }

        bw.write(String.valueOf(maxDistance));
        bw.flush();
        bw.close();
        br.close();
    }
}