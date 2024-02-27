import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        for(int i=1; i<=6; i++){
            dp[i] = i;
        }
        if(N<=6){
            bw.write(String.valueOf(dp[N]));
        }
        else {
            for (int i = 7; i <= N; i++) {
                for (int j = i - 3; j >= 1; j--) {
                    dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
                }
            }
            bw.write(String.valueOf(dp[N]));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}