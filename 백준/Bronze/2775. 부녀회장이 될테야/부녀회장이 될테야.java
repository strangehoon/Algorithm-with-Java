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

        int T = Integer.valueOf(st.nextToken());
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            int k = Integer.valueOf(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int n = Integer.valueOf(st.nextToken());
            int[][] dp = new int[k+1][n+1];
            for(int i=0; i<=n; i++){
                dp[0][i] = i;
            }

            for(int i=1; i<=k; i++){
                for(int j=1; j<=n; j++){
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
            bw.write(String.valueOf(dp[k][n])+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}