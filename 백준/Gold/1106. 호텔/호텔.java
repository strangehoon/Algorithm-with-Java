import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        final int maxValue = 100000;
        
        int[][] dp = new int[N+1][maxValue+1];
        int[][] infos = new int[N+1][2];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            infos[i][0] = Integer.parseInt(st.nextToken());
            infos[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=maxValue; j++){
                int[] info = infos[i];

                dp[i][j] = dp[i-1][j];
                if(j-info[0]>=0){
                    dp[i][j] = Math.max(dp[i][j-info[0]] + info[1], dp[i][j]);
                    dp[i][j] = Math.max(dp[i-1][j-info[0]] + info[1], dp[i][j]);
                }
            }
        }

        for(int i=1; i<=100000; i++){
            if(dp[N][i]>=C){
                System.out.println(i);
                return;
            }
        }
    }
}