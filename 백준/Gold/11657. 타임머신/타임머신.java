import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static class Edge {
        int vertex;
        int cost;
        public Edge(int vertex, int cost){
            this.vertex = vertex;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        long[] dist = new long[N+1];
        long[] temDist = new long[N+1];
        for(int i=1; i<=N; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[1] = 0;
        List<List<Edge>> graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.valueOf(st.nextToken());
            int B = Integer.valueOf(st.nextToken());
            int C = Integer.valueOf(st.nextToken());
            graph.get(A).add(new Edge(B, C));
        }

        for(int i=0; i<=M; i++){
            for(int j=1; j<=N; j++){
                if(dist[j]!=Integer.MAX_VALUE){
                    for(Edge tem : graph.get(j)){
                        if(dist[tem.vertex]>dist[j]+tem.cost){
                            dist[tem.vertex] = dist[j] + tem.cost;}
                    }
                }
            }
            if(i==M-1){
                for(int k=1; k<=N; k++){
                    temDist[k] = dist[k];
                }
            }
        }
        boolean flag = true;
        for(int i=1; i<=N; i++){
            if(temDist[i]!=dist[i])
                flag = false;
        }

        if(flag == false){
            bw.write(String.valueOf(-1));
        }
        else{
            for(int i=2; i<=N; i++){
                if(dist[i]==Integer.MAX_VALUE)
                    bw.write(String.valueOf(-1)+"\n");
                else
                    bw.write(String.valueOf(dist[i])+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}