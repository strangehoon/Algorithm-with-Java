import java.io.*;
import java.util.*;
public class Main {
    static int N, cnt;
    static int[][] graph;
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
        if(iy+1<N && graph[ix][iy+1]==0)
            DFS(ix, iy, ix, iy + 1);
    }
    public static void goLength(int jx, int jy, int ix, int iy){
        if(ix+1<N && graph[ix+1][iy]==0)
            DFS(ix, iy, ix + 1, iy);
    }
    public static void goDiagonal(int jx, int jy, int ix, int iy){
        if(iy+1<N && ix+1<N)
            if(graph[ix][iy+1]==0 && graph[ix+1][iy]==0 && graph[ix+1][iy+1]==0)
                DFS(ix,iy,ix+1, iy+1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cnt = 0;
        DFS(0,0, 0,1);
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}