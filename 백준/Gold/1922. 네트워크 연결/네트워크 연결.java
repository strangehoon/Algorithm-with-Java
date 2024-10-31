import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {


    public static int[] arr;

    public static int Find(int v){
        if(arr[v]==v){
            return v;
        }
        else{
            return arr[v] = Find(arr[v]);
        }
    }

    public static void Union(int v1, int v2){

        v1 = Find(v1);
        v2 = Find(v2);
        if(v1>v2)
            arr[v1] = v2;
        else
            arr[v2] = v1;
    }

    public static class Edge implements Comparable<Edge> {
        int s;
        int e;
        int v;

        public Edge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(Edge e) {
            return this.v - e.v;
        }
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        int M = Integer.valueOf(br.readLine());

        arr = new int[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.valueOf(st.nextToken());
            int e = Integer.valueOf(st.nextToken());
            int v = Integer.valueOf(st.nextToken());
            pq.offer(new Edge(s, e, v));
        }

        int cnt = 0;
        int result = 0;
        while(cnt<N-1){
            Edge edge = pq.poll();
            int s = edge.s;
            int e = edge.e;
            int v = edge.v;
            if(Find(s)!=Find(e)){
                Union(s, e);
                cnt++;
                result += v;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}