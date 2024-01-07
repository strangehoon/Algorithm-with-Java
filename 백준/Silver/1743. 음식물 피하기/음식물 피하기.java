import java.io.*;
import java.util.*;

public class Main {

    static int[][]graph;
    static boolean[][]visited;
    static int N,M;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static int BFS(int x, int y){
        Point point = new Point(x, y);
        int cnt = 1;
        visited[x][y] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);
        while (!queue.isEmpty()){
            Point temPoint = queue.poll();
            int temx = temPoint.x;
            int temy = temPoint.y;
            for(int i=0; i<4; i++){
                int nx = temx+dx[i];
                int ny = temy+dy[i];
                if(0<=nx && nx<N && 0<=ny && ny<M){
                    if(graph[nx][ny]==1 && visited[nx][ny]==false){
                        visited[nx][ny]=true;
                        queue.offer(new Point(nx, ny));
                        cnt++;
                    }
                }
            }
        }
        return cnt;

    }

    public static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for(int i=0; i<K; i++){
            st= new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            graph[x][y] = 1;
        }
        visited = new boolean[N][M];
        int max_value = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(graph[i][j]==1 && visited[i][j]==false){
                    max_value = Math.max(BFS(i,j), max_value);
                }
            }
        }

        bw.write(String.valueOf(max_value));
        bw.flush();
        bw.close();
        br.close();
    }
}
