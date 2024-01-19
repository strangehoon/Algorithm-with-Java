import java.io.*;
import java.util.*;
public class Main {

    static int n,m;
    static int[][] graph, dist;
    static int[] dx = {0 ,0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static class Pos{
        int x;
        int y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void BFS(int x, int y){
        dist[x][y]=0;
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(x,y));
        int cnt = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                Pos pos = queue.poll();
                int posX = pos.x;
                int posY = pos.y;
                for(int i=0; i<4; i++) {
                    int nx = posX + dx[i];
                    int ny = posY + dy[i];
                    if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                        if (dist[nx][ny] == 0 && graph[nx][ny] == 1) {
                            dist[nx][ny] = cnt;
                            queue.offer(new Pos(nx, ny));
                        }
                    }
                }
            }
            cnt++;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        dist = new int[n][m];
        int goal_x=-1;
        int goal_y=-1;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j]==2){
                    goal_x=i;
                    goal_y=j;
                }
            }
        }
        BFS(goal_x, goal_y);

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int tem = dist[i][j];
                if(tem==0 && graph[i][j]==1)
                    bw.write(String.valueOf(-1)+" ");
                else
                    bw.write(String.valueOf(dist[i][j])+" ");
            }
            bw.write(String.valueOf("\n"));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}