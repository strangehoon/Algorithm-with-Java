import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static char[][] graph;
    public static int h, w;

    public static class Pos {
        int x;
        int y;
        int d;

        public Pos(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static int bfs(int x, int y){
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(x, y, 0));
        boolean[][] visited = new boolean[h][w];
        visited[x][y] = true;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int maxValue = 0;
        while(!queue.isEmpty()){
            Pos nowPos = queue.poll();
            int nowX = nowPos.x;
            int nowY = nowPos.y;
            int nowD = nowPos.d;
            maxValue = Math.max(maxValue, nowD);

            for(int i=0; i<4; i++){
                int nx = nowX+dx[i];
                int ny = nowY+dy[i];

                if(0<=nx && nx<h && 0<=ny && ny<w){
                    if(graph[nx][ny]=='L' && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        queue.offer(new Pos(nx, ny, nowD+1));
                    }
                }
            }
        }
        return maxValue;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.valueOf(st.nextToken());
        w = Integer.valueOf(st.nextToken());

        graph = new char[h][w];
        for(int i=0; i<h; i++){
            String str = br.readLine();
            for(int j=0; j<w; j++){
                graph[i][j] = str.charAt(j);
            }
        }
        int result = 0;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(graph[i][j]=='L'){
                    result = Math.max(result, bfs(i, j));
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}