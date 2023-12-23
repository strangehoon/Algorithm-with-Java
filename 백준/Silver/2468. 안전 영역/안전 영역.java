import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static int N;

    static int[] dx = {0, 0, 1, -1, -1, 1, 1, -1};

    static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};

    static void DFS(int t, boolean[][] visited, int x, int y){
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(0<=nx && nx<N && 0<=ny && ny<N){
                if(visited[nx][ny]==false && graph[nx][ny]>t){
                    DFS(t, visited, nx, ny);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        int min_value = Integer.MAX_VALUE;
        int max_value = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                min_value = Math.min(min_value, graph[i][j]);
                max_value = Math.max(max_value, graph[i][j]);
            }
        }

        ArrayList<Integer> resultList = new ArrayList<>();
        for(int t=min_value; t<=max_value; t++){
            int result = 0;
            boolean[][]visited = new boolean[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(graph[i][j]>t && visited[i][j]==false){
                        DFS(t, visited, i, j);
                        result++;
                    }
                }
            }
            resultList.add(result);
        }

        Collections.sort(resultList, Collections.reverseOrder());
        if(resultList.get(0)==0)
            bw.write(String.valueOf(1));
        else
            bw.write(String.valueOf(resultList.get(0)));
        bw.flush();
        bw.close();
        br.close();
    }
}