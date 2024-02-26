import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N+1][K+1];

        for(int i=1; i<N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            for (int j = 1; j < K + 1; j++) {
                if (j - W >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W] + V);
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        bw.write(String.valueOf(dp[N][K]));

        bw.flush();
        bw.close();
        br.close();
    }
}