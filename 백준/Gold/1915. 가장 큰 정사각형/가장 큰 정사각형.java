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
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int[][] dp = new int[n+1][m+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j=1; j<=m; j++){
                dp[i][j] = str.charAt(j-1)-'0';
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(dp[i][j]==1){
                    int min_value = Math.min(dp[i-1][j-1], dp[i-1][j]);
                    min_value = Math.min(min_value, dp[i][j-1]);
                    dp[i][j] = min_value+1;
                }
            }
        }

        int max_value = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                max_value = Math.max(max_value, dp[i][j]);
            }
        }

        bw.write(String.valueOf(max_value*max_value));
        bw.flush();
        bw.close();
        br.close();
    }
}