import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());
        int[][] dp = new int[n+1][k+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.valueOf(st.nextToken());
            int v = Integer.valueOf(st.nextToken());
            for(int j=0; j<=k; j++){
                dp[i][j] = dp[i-1][j];
                if(j-w>=0){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w]+v);
                }
            }
        }

        bw.write(String.valueOf(dp[n][k]));
        bw.flush();
        bw.close();
        br.close();
    }
}