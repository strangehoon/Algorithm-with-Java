import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited1;
    static boolean[] visited2;
    public static void BFS(int x){
        Queue<Integer> queue = new LinkedList<>();
        visited1[x] = true;
        System.out.print(x +" ");
        queue.offer(x);
        while (!queue.isEmpty()){
            int tem = queue.poll();
            for(Integer t : graph.get(tem)){
                if(visited1[t]==false){
                    visited1[t] = true;
                    System.out.print(t +" ");
                    queue.offer(t);
                }
            }
        }
    }

    public static void DFS(int x){
        System.out.print(x+" ");
        visited2[x] = true;
        for(Integer t : graph.get(x)){
            if(visited2[t] == false){
                DFS(t);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            graph.get(first).add(second);
            graph.get(second).add(first);
        }
        for(int i=1; i<=N; i++){
            Collections.sort(graph.get(i));
        }
        visited1 = new boolean[N+1];
        visited2 = new boolean[N+1];
        DFS(V);
        System.out.println();
        BFS(V);
        bw.flush();
        bw.close();
        br.close();
    }
}