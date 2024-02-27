import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        for(int i=1; i<n+1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[n+1][k+1];
        for(int i=1; i<=n; i++){
            dp[i][0] = 1;
            for(int j=1; j<=k; j++){
                if(j-arr[i]>=0){
                    dp[i][j] = dp[i][j-arr[i]] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        bw.write(String.valueOf(dp[n][k]));
        bw.flush();
        bw.close();
        br.close();
    }
}