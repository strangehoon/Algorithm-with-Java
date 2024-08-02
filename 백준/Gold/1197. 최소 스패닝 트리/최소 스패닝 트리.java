import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.*;

public class Main {

    public static int[] arr;
    public static int result = 0;

    public static int Find(int x){
        if(arr[x]==x){
            return x;
        }
        else{
            return arr[x] = Find(arr[x]);
        }
    }

    public static void Union(int a, int b){
        a = Find(a);
        b = Find(b);
        if(a!=b){
            arr[b] = a;
        }
    }

    public static class Edge implements Comparable<Edge>{
        int s;
        int e;
        int v;

        public Edge(int s, int e, int v){
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(Edge E){
            return this.v - E.v;
        }
    }


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.valueOf(st.nextToken());
        int E = Integer.valueOf(st.nextToken());
        arr = new int[V+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i=1; i<=V; i++){
            arr[i] = i;
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.valueOf(st.nextToken());
            int e = Integer.valueOf(st.nextToken());
            int v = Integer.valueOf(st.nextToken());
            pq.offer(new Edge(s, e, v));
        }
        int cnt = 0;
        while(cnt<V-1){
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