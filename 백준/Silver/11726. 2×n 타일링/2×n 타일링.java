import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        if(n==1){
            bw.write(String.valueOf(1));
        }
        else {
            int[] dp = new int[n+1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i - 2] + dp[i - 1])%10007;
            }
            bw.write(String.valueOf(dp[n]));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}