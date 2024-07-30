import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public static class Point implements Comparable<Point>{
        int x;
        int y;
        int v;

        public Point(int x, int y, int v){
            this.x = x;
            this.y = y;
            this.v = v;
        }

        @Override
        public int compareTo(Point p){
            return this.v-p.x;
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.valueOf(st.nextToken());
        int N = Integer.valueOf(st.nextToken());
        int[][] graph = new int[N][M];
        int[][] dist = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j=0; j<str.length(); j++){
                graph[i][j] = str.charAt(j)-'0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(0, 0, 0));
        dist[0][0] = 0;

        while(!pq.isEmpty()){
            Point nowPoint = pq.poll();
            int nowX = nowPoint.x;
            int nowY = nowPoint.y;
            int nowV = nowPoint.v;
            if(nowV>dist[nowX][nowY])
                continue;
            for(int i=0; i<4; i++){
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                if(0<=nx && nx<N && 0<=ny && ny<M){
                    if(dist[nx][ny]>dist[nowX][nowY]+graph[nx][ny]){
                        dist[nx][ny] = dist[nowX][nowY]+graph[nx][ny];
                        pq.offer(new Point(nx, ny, dist[nx][ny]));
                    }
                }
            }
        }

        bw.write(String.valueOf(dist[N-1][M-1]));
        bw.flush();
        bw.close();
        br.close();
    }
}