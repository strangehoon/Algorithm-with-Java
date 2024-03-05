import java.io.*;
import java.util.*;

public class Main {

    static int V,E;
    static int[] visited;
    static List<List<Integer>> graph;
    static boolean flag;
    public static void DFS(int x){
        for(Integer t : graph.get(x)){
            if(visited[t]==0){
                visited[t] = visited[x]*-1;
                DFS(t);
            }
            else if(visited[t]==visited[x]){
                flag = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());
        while (K-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            visited = new int[V+1];
            flag = true;
            for(int i=0; i<=V; i++){
                graph.add(new ArrayList<>());
            }
            for(int i=0; i<E; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            for(int i=1; i<=V; i++){
                if(flag==false)
                    break;
                if(visited[i]==0){
                    visited[i] = 1;
                    DFS(i);
                }
            }
            String result = flag == true ? "YES" : "NO";
            bw.write(String.valueOf(result)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}