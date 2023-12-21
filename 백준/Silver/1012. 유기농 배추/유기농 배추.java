import java.io.*;
import java.util.*;

public class Main {
    static int M,N;
    static int[][] graph;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0 ,0};
    public static void DFS(int x, int y) {
        graph[x][y] = 0;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(0<=nx && nx<N && 0<=ny && ny<M){
                if(graph[nx][ny]==1){
                    graph[nx][ny] = 0;
                    DFS(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int result = 0;
            graph = new int[N][M];
            for(int j=0; j<K; j++){
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st2.nextToken());
                int x = Integer.parseInt(st2.nextToken());
                graph[x][y] = 1;
            }

            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(graph[j][k]==1){
                        DFS(j, k);
                        result++;
                    }
                }
            }
            bw.write(String.valueOf(result +"\n"));
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
