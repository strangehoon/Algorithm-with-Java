import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int[][] dp = new int[N+1][10];
        for(int i=1; i<=9; i++){
            dp[1][i] = 1;
        }
        for(int i=2; i<=N; i++){
            for(int j=0; j<=9; j++){
                if(j-1>=0){
                    dp[i][j] += dp[i-1][j-1];
                    dp[i][j] %= 1000000000;
                }
                if(j+1<=9){
                    dp[i][j] += dp[i-1][j+1];
                    dp[i][j] %= 1000000000;
                }
            }
        }
        int result = 0;
        for(int i=0; i<=9; i++){
            result += dp[N][i];
            result %= 1000000000;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}