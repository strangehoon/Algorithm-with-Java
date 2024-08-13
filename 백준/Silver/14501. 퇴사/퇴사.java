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
        int n = Integer.valueOf(st.nextToken());
        int[] dp = new int[n+2];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.valueOf(st.nextToken());
            int p = Integer.valueOf(st.nextToken());
            for(int j=1; j<i; j++){
                dp[i] = Math.max(dp[j], dp[i]);
            }
            if(i+t<=n+1)
                dp[i+t] = Math.max(dp[i+t], dp[i]+p);
        }
        int result = Integer.MIN_VALUE;
        for(int i=1; i<=n+1; i++){
            result = Math.max(result, dp[i]);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}