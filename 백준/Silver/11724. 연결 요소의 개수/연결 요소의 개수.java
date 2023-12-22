import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;

    static boolean[] visited;

    static void DFS(int i){
        visited[i] = true;

        for(int j=0; j< graph.get(i).size();j++){
            int x = graph.get(i).get(j);
            if(!visited[x]){
                DFS(x);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = 0;
        graph = new ArrayList<>();
        visited = new boolean[N];
        for(int i=0; i<N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            graph.get(a-1).add(b-1);
            graph.get(b-1).add(a-1);
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                DFS(i);
                result ++;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
