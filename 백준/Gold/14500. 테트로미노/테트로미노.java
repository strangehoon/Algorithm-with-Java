import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static int[][] result;
    static int N, M;
    static int[] dx = {0 ,0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void DFS(int x, int y, int cnt, int sum, boolean[][] visited){
        if(cnt==4){
            result[x][y] = Math.max(result[x][y], sum);
            return ;
        }
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(0<=nx && nx<N && 0<=ny && ny<M){
                if(visited[nx][ny]==false){
                    visited[nx][ny] = true;
                    DFS(nx, ny, cnt+1, sum+graph[nx][ny], visited);
                    visited[nx][ny]= false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // DFS 수행('ㅜ' 제외)
        result = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if((i+j)%2==0)
                    continue;
                boolean[][] visited = new boolean[N][M];
                visited[i][j] = true;
                DFS(i, j, 1, graph[i][j], visited);
            }
        }
        // 'ㅜ' 모양
        int max_value = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                List<Integer> tem = new ArrayList<>();
                int sum = graph[i][j];
                for(int k=0; k<4; k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if(0<=nx && nx<N && 0<=ny && ny<M){
                        tem.add(graph[nx][ny]);
                    }
                }
                if(tem.size()>=3){
                    Collections.sort(tem, Collections.reverseOrder());
                    sum += tem.get(0) + tem.get(1) + tem.get(2);
                }
                max_value = Math.max(sum, max_value);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                max_value = Math.max(max_value, result[i][j]);
            }
        }
        bw.write(String.valueOf(max_value));
        bw.flush();
        bw.close();
        br.close();
    }
}