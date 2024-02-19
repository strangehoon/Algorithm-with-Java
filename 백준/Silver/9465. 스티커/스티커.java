import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][N];
            int[][] dp = new int[2][N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[0][i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[1][i] = Integer.parseInt(st.nextToken());
            }
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            if(N==1) {
                bw.write(String.valueOf(Math.max(dp[0][N - 1], dp[1][N - 1]))+"\n");
                continue;
            }
            dp[0][1] = dp[1][0] + arr[0][1];
            dp[1][1] = dp[0][0] + arr[1][1];
            if(N==2) {
                bw.write(String.valueOf(Math.max(dp[0][1], dp[1][1]))+"\n");
                continue;
            }
            for(int i=3; i<=N; i++){
                dp[0][i-1] = Math.max(dp[1][i-2], dp[1][i-3])+ arr[0][i-1];
                dp[1][i-1] = Math.max(dp[0][i-2], dp[0][i-3])+ arr[1][i-1];
            }
            bw.write(String.valueOf(Math.max(dp[0][N-1], dp[1][N-1]))+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}