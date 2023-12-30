import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> graph;
    static int[] visited;

    static int flag = 1;
    public static void DFS(int a, int value){
        if(flag == 0){
            return;
        }
        else {
            visited[a] = value;
            for (int tem : graph.get(a)) {
                if (visited[tem] == 0) {
                    visited[tem] = value * -1;
                    DFS(tem, value*-1);
                } else if (visited[tem] == value) {
                    flag = 0;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i=0; i<N+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
            graph.get(B).add(A);
        }
        visited = new int[N+1];

        for(int i=1; i<N+1; i++){
            if(visited[i]==0){
                DFS(i, 1);
            }
        }
        bw.write(String.valueOf(flag));

        bw.flush();
        bw.close();
        br.close();
    }
}
