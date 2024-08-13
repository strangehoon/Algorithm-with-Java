import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static int[] dp;
    public static int recur(int x){
        if(dp[x]!=-1){
            return dp[x];
        }
        else{
            return dp[x] = recur(x-2)+recur(x-1);
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());

        dp = new int[n+1];
        for(int i=0; i<=n; i++){
            dp[i] = -1;
        }
        dp[0] = 0;
        dp[1] = 1;
        bw.write(String.valueOf(recur(n)));

        bw.flush();
        bw.close();
        br.close();
    }
}