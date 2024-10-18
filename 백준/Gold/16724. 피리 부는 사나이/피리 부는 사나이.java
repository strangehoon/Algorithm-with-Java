import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static char[][] graph;
    static boolean[][] visited;
    static HashMap<Character, Pos> map = new HashMap<>();
    static int answer = 0;
    static int N, M;

    static class Pos{
        int x;
        int y;

        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void Go(int x, int y){
        visited[x][y] = true;
        Pos curPos = map.get(graph[x][y]);

        int curX = x+curPos.x;
        int curY = y+curPos.y;

        if(!visited[curX][curY]){
            Go(curX, curY);
        }

        // 동
        int ex = x;
        int ey = y+1;
        if(0<=ex && ex<N && 0<=ey && ey<M){
            if(graph[ex][ey]=='L' && !visited[ex][ey]) {
                Go(ex, ey);
            }
        }

        // 서
        int wx = x;
        int wy = y-1;
        if(0<=wx && wx<N && 0<=wy && wy<M){
            if(graph[wx][wy]=='R' && !visited[wx][wy]) {
                Go(wx, wy);
            }
        }

        // 남
        int sx = x+1;
        int sy = y;
        if(0<=sx && sx<N && 0<=sy && sy<M){
            if(graph[sx][sy]=='U' && !visited[sx][sy]) {
                Go(sx, sy);
            }
        }

        // 북
        int nx = x-1;
        int ny = y;
        if(0<=nx && nx<N && 0<=ny && ny<M){
            if(graph[nx][ny]=='D' && !visited[nx][ny]) {
                Go(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        graph = new char[N][M];
        visited = new boolean[N][M];

        map = new HashMap<>();
        map.put('D', new Pos(1, 0));
        map.put('R', new Pos(0, 1));
        map.put('L', new Pos(0, -1));
        map.put('U', new Pos(-1, 0));

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                graph[i][j] = str.charAt(j);
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j]){
                    Go(i, j);
                    answer++;
                }
            }
        }


        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}