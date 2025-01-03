import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int K = Integer.valueOf(st.nextToken());

        int[][] dp = new int[N+1][K+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.valueOf(st.nextToken());
            int v = Integer.valueOf(st.nextToken());
            for(int j=1; j<=K; j++){
                dp[i][j] = dp[i-1][j];
                if(j-w>=0)
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w]+v);
            }
        }
        System.out.println(dp[N][K]);
    }
}