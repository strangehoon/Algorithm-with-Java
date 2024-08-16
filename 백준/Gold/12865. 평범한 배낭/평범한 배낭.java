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
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        int[][] dp = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int W = Integer.valueOf(st.nextToken());
            int V = Integer.valueOf(st.nextToken());
            for(int j=M; j>=0; j--){
                dp[i][j] = dp[i-1][j];
                if(j-W>=0){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-W]+V);
                }
            }
        }

        bw.write(String.valueOf(dp[N][M]));
        bw.flush();
        bw.close();
        br.close();
    }
}