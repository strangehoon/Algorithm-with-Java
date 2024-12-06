import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static int[] arr;

    public static class Edge implements Comparable<Edge> {
        int s;
        int e;
        int v;
        public Edge(int s, int e, int v){
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(Edge e){
            return this.v-e.v;
        }
    }

    public static int find(int x){
        if(arr[x]==x){
            return x;
        }
        else{
            return arr[x] = find(arr[x]);
        }
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a>=b){
            arr[a] = b;
        }
        else{
            arr[b] = a;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        arr = new int[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            int c = Integer.valueOf(st.nextToken());
            pq.offer(new Edge(a, b, c));
        }

        int cnt = N-1;
        List<Integer> costList = new ArrayList<>();

        int totalCost = 0;
        while (cnt>0){
            Edge nowEdge = pq.poll();
            int nowS = nowEdge.s;
            int nowE = nowEdge.e;
            int nowV = nowEdge.v;

            if(find(nowS)!=find(nowE)){
                union(nowS, nowE);
                cnt--;
                costList.add(nowV);
                totalCost += nowV;
            }
        }
        Collections.sort(costList);
        int tem = costList.get(costList.size()-1);
        bw.write(String.valueOf(totalCost-tem));

        bw.flush();
        bw.close();
        br.close();
    }
}