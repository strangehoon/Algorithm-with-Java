import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static class Edge{
        int v;
        int d;
        public Edge(int v, int d){
            this.v = v;
            this.d = d;
        }
    }
    public static int V;
    public static List<List<Edge>> graph;
    public static int[] distance;


    public static void BFS(int idx){
        distance = new int[V+1];
        for(int i=1; i<=V; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[idx] = 0;
        Queue<Edge> queue = new LinkedList<>();
        queue.offer(new Edge(idx, 0));
        while(!queue.isEmpty()){
            Edge tem = queue.poll();

            for(Edge x : graph.get(tem.v)){
                if(distance[x.v]==Integer.MAX_VALUE){
                    distance[x.v] = x.d + distance[tem.v];
                    queue.offer(x);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.valueOf(st.nextToken());
        graph = new ArrayList<>();
        for(int i=0; i<=V; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<V; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.valueOf(st.nextToken());
            while(true){
                int v = Integer.valueOf(st.nextToken());
                if(v==-1)
                    break;
                else{
                    int d = Integer.valueOf(st.nextToken());
                    graph.get(num).add(new Edge(v, d));
                }
            }
        }

        BFS(2);
        int max_idx = -1;
        int max_value = Integer.MIN_VALUE;
        for(int i=1; i<=V; i++){
            if(max_value<distance[i]){
                max_value = distance[i];
                max_idx = i;
            }
        }
        BFS(max_idx);

        Arrays.sort(distance);
        bw.write(String.valueOf(distance[V]));
        bw.flush();
        bw.close();
        br.close();
    }
}