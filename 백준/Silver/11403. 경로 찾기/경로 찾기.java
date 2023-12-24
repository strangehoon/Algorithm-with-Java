import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static int N;

    static int[] dx = {0, 0, 1, -1, -1, 1, 1, -1};

    static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};

    static void DFS(int x, int[] visited){
        for(int j=0; j<N; j++){
            if(graph[x][j]==1 && visited[j]==0){
                visited[j] = 1;
                DFS(j, visited);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++){
            int[]visited = new int[N];
            DFS(i, visited);
            for(int j=0; j<N; j++){
                bw.write(String.valueOf(visited[j]) +" ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
