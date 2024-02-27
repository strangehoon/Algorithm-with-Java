import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[N-1][21];
        dp[0][arr[0]] = 1;
        for(int i=1; i<N-1; i++){
            int t = arr[i];
            for(int j=0; j<21; j++){
                if(dp[i-1][j]>0){
                    if(j-t>=0){
                        dp[i][j-t] += dp[i-1][j];
                    }
                    if (j+t<=20) {
                        dp[i][j + t] += dp[i - 1][j];
                    }
                }
            }
        }
        int goal = arr[N-1];
        bw.write(String.valueOf(dp[N-2][goal]));

        bw.flush();
        bw.close();
        br.close();
    }
}