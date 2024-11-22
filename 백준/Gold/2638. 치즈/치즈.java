import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    // 22:05

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0 ,0, 1, -1};

    public static class Pos{
        int x;
        int y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        int[][] graph = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                graph[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        boolean flag = true;
        int t = 0;

        while (flag){
            t++;
            Queue<Pos> queue = new LinkedList<>();
            queue.offer(new Pos(0, 0));
            boolean[][] visited = new boolean[N][M];
            visited[0][0] = true;

            int[][] airVisitedCheese = new int[N][M];

            while (!queue.isEmpty()){
                Pos nowPos = queue.poll();
                int nowX = nowPos.x;
                int nowY = nowPos.y;

                for(int i=0; i<4; i++){
                    int nx = nowX+dx[i];
                    int ny = nowY+dy[i];
                    if(0<=nx && nx<N && 0<=ny && ny<M){
                        if(graph[nx][ny]==0 && visited[nx][ny]==false){
                            visited[nx][ny] = true;
                            queue.offer(new Pos(nx, ny));
                        }
                        else if(graph[nx][ny]==1){
                            airVisitedCheese[nx][ny]+=1;
                        }
                    }
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(airVisitedCheese[i][j]>=2){
                        graph[i][j] = 0;
                    }
                }
            }

            int cnt = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(graph[i][j]==1){
                        cnt++;
                    }
                }
            }
            if(cnt==0)
                flag=false;
        }

        bw.write(String.valueOf(t));
        bw.flush();
        bw.close();
        br.close();
    }
}