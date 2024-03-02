import java.io.*;
import java.util.*;

public class Main {
    static List<Pos> posList;
    static boolean[][] visited;
    static int[][] graph;
    static int N, L, R;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static class Pos{
        int x;
        int y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static int BFS(int x, int y){
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(x, y));
        visited[x][y] = true;
        posList.add(new Pos(x, y));
        int sum = graph[x][y];
        while (!queue.isEmpty()){
            Pos curPos = queue.poll();
            for(int i=0; i<4; i++){
                int nx = curPos.x +dx[i];
                int ny = curPos.y +dy[i];
                if(0<=nx && nx<N && 0<=ny && ny<N){
                    int dist = Math.abs(graph[nx][ny]-graph[curPos.x][curPos.y]);
                    if(visited[nx][ny]==false && L<=dist && dist<=R){
                        visited[nx][ny] = true;
                        queue.offer(new Pos(nx, ny));
                        posList.add(new Pos(nx, ny));
                        sum += graph[nx][ny];
                    }
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        while (true){
            visited = new boolean[N][N];
            boolean flag = false;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    posList = new ArrayList<>();
                    if(visited[i][j]==true)
                        continue;
                    int sum = BFS(i, j);
                    if(posList.size()>1){
                        for(Pos pos : posList){
                            graph[pos.x][pos.y] = sum/posList.size();
                        }
                        flag = true;
                    }
                }
            }
            
            if(flag==true)
                cnt++;
            else
                break;
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}