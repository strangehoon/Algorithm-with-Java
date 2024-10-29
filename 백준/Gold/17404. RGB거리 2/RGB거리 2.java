import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        int[][] arr = new int[N][3];
        final int MAX_VALUE = 1000000;

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.valueOf(st.nextToken());
            arr[i][1] = Integer.valueOf(st.nextToken());
            arr[i][2] = Integer.valueOf(st.nextToken());
        }
        int result = Integer.MAX_VALUE;

        for(int i=0; i<3; i++){
            int[][] dp = new int[N][3];
            dp[0][i] = arr[0][i];
            dp[0][(i+1)%3] = MAX_VALUE;
            dp[0][(i+2)%3] = MAX_VALUE;

            for(int j=1; j<N; j++){
                dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2]) + arr[j][0];
                dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2]) + arr[j][1];
                dp[j][2] = Math.min(dp[j-1][0], dp[j-1][1]) + arr[j][2];
            }

            int tem = Math.min(dp[N-1][(i+1)%3], dp[N-1][(i+2)%3]);
            result = Math.min(result, tem);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}