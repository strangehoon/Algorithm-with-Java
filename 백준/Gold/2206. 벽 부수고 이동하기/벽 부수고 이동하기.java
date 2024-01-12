import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Pos{
        int x;
        int y;
        int z;
        public Pos(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static int N,M;
    static int[][] graph;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static int BFS(){
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(0, 0, 0));
        int[][][] visited = new int[2][N][M];
        visited[0][0][0] = 1;
        while (!queue.isEmpty()){
            Pos tem = queue.poll();
            int x = tem.x;
            int y = tem.y;
            int z = tem.z;
            if(x==N-1 &&y==M-1){
                return Math.max(visited[0][x][y], visited[1][x][y]);
            }

            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0<=nx && nx<N && 0<=ny && ny<M){
                    // 아직 벽 안부숨
                    if(z==0){
                        // 이동 가능
                        if(graph[nx][ny]==0 && visited[0][nx][ny]==0){
                            visited[0][nx][ny] = visited[0][x][y]+1;
                            queue.offer(new Pos(nx, ny, 0));
                        }
                        // 벽 만남
                        else if (graph[nx][ny]==1 && visited[1][nx][ny]==0){
                            visited[1][nx][ny] = visited[0][x][y]+1;
                            queue.offer(new Pos(nx, ny, 1));
                        }
                    }
                    // 이미 벽 부수었음
                    else {
                        if(graph[nx][ny]==0 && visited[1][nx][ny]==0){
                            visited[1][nx][ny] = visited[1][x][y]+1;
                            queue.offer(new Pos(nx, ny, 1));
                        }
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<str.length(); j++){
                graph[i][j] = str.charAt(j)-'0';
            }
        }

        bw.write(String.valueOf(BFS()));

        bw.flush();
        bw.close();
        br.close();
    }
}