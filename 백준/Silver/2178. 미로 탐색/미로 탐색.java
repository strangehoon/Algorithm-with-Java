import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] graph;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static int BFS(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        boolean[][] visited = new boolean[N][M];
        visited[x][y] = true;
        int dist = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                Point curPoint = queue.poll();
                int curX = curPoint.x;
                int curY = curPoint.y;
                if (curX == N-1 && curY == M-1){
                    return dist;
                }
                for(int i=0; i<4; i++){
                    int nx = curX + dx[i];
                    int ny = curY + dy[i];
                    if(0<=nx && nx<N && 0<= ny && ny<M){
                        if (graph[nx][ny]=='1' && visited[nx][ny]==false){
                            visited[nx][ny] = true;
                            queue.offer(new Point(nx, ny));
                        }
                    }
                }
            }
            dist ++;

        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new char[N][M];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<str.length(); j++){
                graph[i][j] = str.charAt(j);
            }
        }

        bw.write(String.valueOf(BFS(0, 0)));
        bw.flush();
        bw.close();
        br.close();
    }
}