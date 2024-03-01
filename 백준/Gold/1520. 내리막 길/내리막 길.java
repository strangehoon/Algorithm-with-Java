import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[][] graph;
    static int[][] dp;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static int DFS(int x, int y){
        if(x==M-1 && y==N-1){
            return 1;
        }
        if(dp[x][y]!=-1){
            return dp[x][y];
        }
        dp[x][y] = 0;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(0<=nx && nx<M && 0<=ny && ny<N){
                if(visited[nx][ny]==false && graph[nx][ny]<graph[x][y]){
                    visited[nx][ny] = true;
                    dp[x][y] += DFS(nx, ny);
                    visited[nx][ny] = false;
                }
            }
        }
        return dp[x][y];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new int[M][N];
        visited = new boolean[M][N];
        dp = new int[M][N];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        visited[0][0] = true;
        bw.write(String.valueOf(DFS(0,0)));

        bw.flush();
        bw.close();
        br.close();
    }
}