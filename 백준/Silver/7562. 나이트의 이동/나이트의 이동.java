import java.io.*;
import java.util.*;

public class Main {

    static int[][] graph;

    static int N,x2,y2;

    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};

    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static class Pos{
        int x;
        int y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static int BFS(Pos startPos) {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(startPos);
        while (!queue.isEmpty()){
            Pos p = queue.poll();
            if(p.x == x2 && p.y == y2){
                break;
            }
            for(int i=0; i<8; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(0<=nx && nx<N && 0<=ny && ny<N){
                    if(graph[nx][ny]==0){
                        graph[nx][ny] = graph[p.x][p.y]+1;
                        queue.offer(new Pos(nx, ny));
                    }
                }
            }
        }
        return graph[x2][y2];

    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            N = Integer.parseInt(br.readLine());
            graph= new int[N][N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(BFS(new Pos(x1, y1))+"\n"));
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
