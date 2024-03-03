import java.io.*;
import java.util.*;

public class Main {
    static int K, N, M;
    static List<List<Integer>> graph;
    static List<Integer> result;
    public static void BFS(int x){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        boolean[] visited = new boolean[N+1];
        visited[x] = true;
        int dist = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                int tem = queue.poll();
                if(dist==K){
                    result.add(tem);
                }
                for(Integer t : graph.get(tem)){
                    if (!visited[t]){
                        visited[t] = true;
                        queue.add(t);
                    }
                }
            }
            dist++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        result = new ArrayList<>();
        for(int i=0; i<N+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
        }
        BFS(X);
        Collections.sort(result);
        if(result.size()==0){
            bw.write(String.valueOf(-1));
        }
        else {
            for(Integer t : result){
                bw.write(String.valueOf(t)+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}