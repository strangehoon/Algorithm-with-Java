import java.io.*;
import java.util.*;
public class Main {
    static int N, cnt;
    static int[][] graph;
    static boolean[][] visited;
    public static void DFS(int jx, int jy, int ix, int iy){
        if(ix==N-1 && iy==N-1){
            cnt++;
            return;
        }
        // case 1 : 파이프가 가로
        if(jx==ix){
            goWidth(jx, jy, ix, iy);
            goDiagonal(jx, jy, ix, iy);
        }
        // case 2 : 파이프가 세로
        if(jy==iy){
            goDiagonal(jx, jy, ix, iy);
            goLength(jx, jy, ix, iy);
        }
        // case 3 : 파이프가 대각선
        if(ix==jx+1 && iy==jy+1){
            goWidth(jx, jy, ix, iy);
            goDiagonal(jx, jy, ix, iy);
            goLength(jx, jy, ix, iy);
        }
    }

    public static void goWidth(int jx, int jy, int ix, int iy){
        if(iy+1<N && visited[ix][iy+1]==false){
            if(graph[ix][iy+1]==0) {
                visited[ix][iy + 1] = true;
                DFS(ix, iy, ix, iy + 1);
                visited[ix][iy + 1] = false;
            }
        }
    }
    public static void goLength(int jx, int jy, int ix, int iy){
        if(ix+1<N && visited[ix+1][iy]==false){
            if(graph[ix+1][iy]==0) {
                visited[ix + 1][iy] = true;
                DFS(ix, iy, ix + 1, iy);
                visited[ix + 1][iy] = false;
            }
        }
    }
    public static void goDiagonal(int jx, int jy, int ix, int iy){
        if(iy+1<N && ix+1<N){
            if(visited[ix][iy+1]==false && visited[ix+1][iy]==false && visited[ix+1][iy+1]==false){
                if(graph[ix][iy+1]==0 && graph[ix+1][iy]==0 && graph[ix+1][iy+1]==0){
                    visited[ix][iy+1]=true;
                    visited[ix+1][iy]=true;
                    visited[ix+1][iy+1]=true;
                    DFS(ix,iy,ix+1, iy+1);
                    visited[ix][iy+1]=false;
                    visited[ix+1][iy]=false;
                    visited[ix+1][iy+1]=false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[0][0] = true;
        visited[0][1] = true;
        cnt = 0;
        DFS(0,0, 0,1);
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}