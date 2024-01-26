import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static boolean[] visited;
    static int[] parent;
    static List<List<Integer>> graph;
    public static void BFS(int root){
        visited[root] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int tem = queue.poll();
            for(int x : graph.get(tem)){
                if(!visited[x]){
                    visited[x] = true;
                    parent[x] = tem;
                    queue.offer(x);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        parent = new int[N+1];
        graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        BFS(1);
        for(int i=2; i<=N; i++){
            bw.write(String.valueOf(parent[i])+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}