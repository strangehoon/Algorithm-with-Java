import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static int M, N;

    static List<Point> pointList;

    static int[] dx = {0, 0, 1, -1};

    static int[] dy = {1, -1, 0, 0};

    static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void BFS(){
        Queue<Point> queue = new LinkedList<>();
        for(Point point : pointList){
            queue.add(point);
        }

        while (!queue.isEmpty()){
            Point p = queue.poll();
            for(int i=0; i<4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(0<=nx && nx<N && 0<=ny && ny<M){
                    if(graph[nx][ny]==0) {
                        graph[nx][ny] = graph[p.x][p.y] + 1;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pointList = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(graph[i][j]==1){
                    pointList.add(new Point(i, j));
                }
            }
        }
        BFS();
        int max_value = Integer.MIN_VALUE;
        boolean flag = true;
        for(int i=0; i<N; i++){
            if(flag==false)
                break;
            for(int j=0; j<M; j++){
                if(graph[i][j]==0){
                    bw.write(String.valueOf(-1));
                    flag = false;
                    break;
                }
                max_value = Integer.max(max_value, graph[i][j]);
            }
        }
        if(flag==true) {
            if (max_value == 1)
                bw.write(String.valueOf(0));
            else
                bw.write(String.valueOf(max_value-1));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
