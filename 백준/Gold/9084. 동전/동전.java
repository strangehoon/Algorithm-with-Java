import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[i+1] = Integer.parseInt(st.nextToken());
            }
            int goal = Integer.parseInt(br.readLine());
            int[][] dp = new int[N+1][goal+1];

            for(int i=1; i<=N; i++){
                dp[i][0] = 1;
                for(int j=1; j<goal+1; j++){
                    if(j-arr[i]>=0){
                        dp[i][j] = dp[i][j-arr[i]] + dp[i-1][j];
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            bw.write(String.valueOf(dp[N][goal])+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}