import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.*;

public class Main {

    public static class Edge{
        int start;
        int end;
        int value;

        public Edge(int start, int end, int value){
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        Long[] dist = new Long[N+1];
        for(int i=0; i<=N; i++){
            dist[i] = Long.MAX_VALUE;
        }
        dist[1] = 0l;
        List<Edge> list = new ArrayList<>();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.valueOf(st.nextToken());
            int e = Integer.valueOf(st.nextToken());
            int v = Integer.valueOf(st.nextToken());
            list.add(new Edge(s, e, v));
        }
        int cnt = 0;
        boolean flag = true;
        while(cnt<N){
            for(int i=0; i<M; i++){
                Edge edge = list.get(i);
                if(dist[edge.start]!=Long.MAX_VALUE && dist[edge.end]>dist[edge.start]+edge.value){
                    dist[edge.end] = dist[edge.start] + edge.value;
                    if(cnt==N-1){
                        flag = false;
                    }
                }
            }
            cnt++;
        }
        if(flag == true){
            for(int i=2; i<=N; i++){
                if(dist[i]==Long.MAX_VALUE)
                    bw.write(String.valueOf(-1)+"\n");
                else
                    bw.write(String.valueOf(dist[i])+"\n");
            }
        }
        else
            bw.write(String.valueOf(-1));

        bw.flush();
        bw.close();
        br.close();
    }
}