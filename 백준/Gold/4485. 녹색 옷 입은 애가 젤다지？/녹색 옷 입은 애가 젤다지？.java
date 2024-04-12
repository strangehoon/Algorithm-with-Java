import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int[][] graph;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N;
    public static class Node implements Comparable<Node>{
        int x;
        int y;
        int d;

        public Node(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }

        @Override
        public int compareTo(Node o1){
            return this.d - o1.d;
        }

    }

    public static void BFS(int x, int y){
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Node(x, y, graph[x][y]));
        dp[x][y] = graph[x][y];
        while (!priorityQueue.isEmpty()){
            Node nowNode = priorityQueue.poll();
            int nowX = nowNode.x;
            int nowY = nowNode.y;
            int nowD = nowNode.d;
            if(dp[nowX][nowY]<nowD)
                continue;
            for(int i=0; i<4; i++){
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                if(0<=nx && nx<N && 0<=ny && ny<N){
                    if(dp[nx][ny]>nowD+graph[nx][ny]){
                        dp[nx][ny] = nowD+graph[nx][ny];
                        priorityQueue.offer(new Node(nx, ny, dp[nx][ny]));
                    }
                }
            }
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = 1;
        while (true){
            N = Integer.parseInt(br.readLine());
            if(N==0)
                break;
            graph = new int[N][N];
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp = new int[N][N];
            for(int i=0; i<N; i++){
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            BFS(0,0);
            System.out.println("Problem "+cnt+": " + dp[N-1][N-1]);
            cnt++;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}