import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int M,N;

    static int[][]graph;
    public static int DFS(int x, int y, int area){

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(0<=nx && nx<N && 0<=ny && ny<M){
                if(graph[nx][ny]==0){
                    graph[nx][ny] = 1;
                    area = DFS(nx, ny, area+1);
                }
            }
        }
        return area;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for(int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int first_x = Integer.parseInt(st.nextToken());
            int first_y = Integer.parseInt(st.nextToken());
            int second_x = Integer.parseInt(st.nextToken());
            int second_y = Integer.parseInt(st.nextToken());
            for(int j=first_x; j<second_x; j++){
                for(int k=first_y; k<second_y; k++){
                    graph[j][k] = 1;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(graph[i][j]==0) {
                    graph[i][j] = 1;
                    list.add(DFS(i, j, 1));
                }
            }
        }
        Collections.sort(list);
        bw.write(String.valueOf(list.size()) +"\n");
        for(int i=0; i<list.size(); i++){
            bw.write(list.get(i) +" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
