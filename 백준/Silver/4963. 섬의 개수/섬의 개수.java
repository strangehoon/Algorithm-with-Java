import java.io.*;
import java.util.*;

public class Main {

    public static int w, h;
    public static int[][] graph;
    public static boolean[][] visited;

    public static int[] dx = {0, 0, 1, -1, -1, 1, 1, -1};
    public static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};
    public static void DFS(int x, int y){
        for(int i=0; i<8; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(0<=nx && nx<h && 0<=ny && ny<w){
                if(graph[nx][ny]==1 && visited[nx][ny]==false){
                    visited[nx][ny]=true;
                    DFS(nx, ny);
                }
            }
        }
    }
    public static class Document{
        int num;
        int idx;

        public Document(int num, int idx){
            this.num = num;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w==0 && h==0){
                break;
            }
            graph = new int[h][w];
            visited = new boolean[h][w];
            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int result = 0;
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(graph[i][j]==1 && visited[i][j]==false){
                        result++;
                        visited[i][j]=true;
                        DFS(i, j);
                    }
                }
            }
            bw.write(String.valueOf(result)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}