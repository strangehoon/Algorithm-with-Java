import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];
        long[][] dp = new long[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1L;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int tem = graph[i][j];
                if(tem>0 && i+tem<N){
                    dp[i+tem][j] += dp[i][j];
                }
                if (tem>0 && j+tem<N) {
                    dp[i][j+tem] += dp[i][j];
                }
            }
        }
        bw.write(String.valueOf(dp[N-1][N-1]));
        bw.flush();
        bw.close();
        br.close();
    }
}