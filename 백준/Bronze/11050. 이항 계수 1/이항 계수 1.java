import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        int K = Integer.valueOf(st.nextToken());

        int[][] dp = new int[N+1][N+1];
        for(int i=0; i<=N; i++){
            dp[i][0] = 1;
            dp[i][1] = i;
            dp[i][i] = 1;
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<i; j++){
               dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
            }
        }

        bw.write(String.valueOf(dp[N][K]));
        bw.flush();
        bw.close();
        br.close();
    }
}