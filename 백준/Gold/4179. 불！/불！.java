import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static int R,C;
    public static char[][] graph;
    public static int[][] jDistance;
    public static int[][] fireDistance;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static class Pos{
        int x;
        int y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void jBfs(int x, int y) {
        jDistance = new int[R][C];
        for(int i=0; i<R; i++){
            Arrays.fill(jDistance[i], Integer.MAX_VALUE);
        }
        jDistance[x][y] = 0;
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(x, y));

        while (!queue.isEmpty()){
            Pos nowPos = queue.poll();
            int nowX = nowPos.x;
            int nowY = nowPos.y;

            for(int i=0; i<4; i++){
                int nx = nowX+dx[i];
                int ny = nowY+dy[i];
                if(0<=nx && nx<R && 0<=ny && ny<C){
                    if(graph[nx][ny]=='.' && jDistance[nx][ny]==Integer.MAX_VALUE){
                        jDistance[nx][ny] = jDistance[nowX][nowY]+1;
                        queue.offer(new Pos(nx, ny));
                    }
                }
            }
        }
    }

    public static void fireBfs(List<Pos> firePosList){
        fireDistance = new int[R][C];
        for(int i=0; i<R; i++){
            Arrays.fill(fireDistance[i], Integer.MAX_VALUE);
        }
        for(Pos pos : firePosList){
            fireDistance[pos.x][pos.y] = 0;
        }
        Queue<Pos> queue = new LinkedList<>();
        for(Pos pos : firePosList){
            queue.offer(pos);
        }

        while (!queue.isEmpty()){
            Pos nowPos = queue.poll();
            int nowX = nowPos.x;
            int nowY = nowPos.y;

            for(int i=0; i<4; i++){
                int nx = nowX+dx[i];
                int ny = nowY+dy[i];
                if(0<=nx && nx<R && 0<=ny && ny<C) {
                    if (graph[nx][ny] == '.' && fireDistance[nx][ny] == Integer.MAX_VALUE) {
                        fireDistance[nx][ny] = fireDistance[nowX][nowY] + 1;
                        queue.offer(new Pos(nx, ny));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.valueOf(st.nextToken());
        C = Integer.valueOf(st.nextToken());

        graph = new char[R][C];
        Pos jPos = null;
        List<Pos> firePosList = new ArrayList<>();
        for(int i=0; i<R; i++){
            String str = br.readLine();
            for(int j=0; j<C; j++){
                graph[i][j] = str.charAt(j);
                if(graph[i][j]=='J'){
                    jPos = new Pos(i, j);
                } else if (graph[i][j]=='F') {
                    firePosList.add(new Pos(i, j));
                }
            }
        }

        jBfs(jPos.x, jPos.y);
        fireBfs(firePosList);

        int minValue = Integer.MAX_VALUE;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(i==0 || i==R-1 || j==0 || j==C-1){
                    if(jDistance[i][j]<fireDistance[i][j]){
                        minValue = Math.min(minValue, jDistance[i][j]+1);
                    }
                }
            }
        }

        if(minValue==Integer.MAX_VALUE){
            bw.write("IMPOSSIBLE");
        }
        else{
            bw.write(String.valueOf(minValue));
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
