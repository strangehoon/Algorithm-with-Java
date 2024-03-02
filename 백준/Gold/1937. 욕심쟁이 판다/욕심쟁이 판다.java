import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] dp;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static int DFS(int x, int y){
        visited[x][y] = true;
        int cnt = 1;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(0<=nx && nx<N && 0<=ny && ny<N){
                if(graph[x][y]<graph[nx][ny]){
                    if(dp[nx][ny]!=0){
                        cnt = Math.max(cnt, dp[nx][ny]+1);
                    }
                    else
                        cnt = Math.max(cnt, DFS(nx, ny)+1);
                }
            }
        }
        dp[x][y] = cnt;
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        dp = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][N];
        int max_value = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j])
                    continue;
                max_value = Math.max(max_value, DFS(i, j));
            }
        }

        bw.write(String.valueOf(max_value));
        bw.flush();
        bw.close();
        br.close();
    }
}