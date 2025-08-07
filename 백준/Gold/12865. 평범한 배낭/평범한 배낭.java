import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][2];
        int[] dp = new int[k+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[i][0] = w;
            arr[i][1] = v;
        }

        for(int i=1; i<=n; i++){
            for(int j=k; j>=0; j--){
                if(j-arr[i][0]>=0)
                    dp[j] = Math.max(dp[j], arr[i][1] + dp[j-arr[i][0]]);
            }
        }

        System.out.println(dp[k]);
    }
}