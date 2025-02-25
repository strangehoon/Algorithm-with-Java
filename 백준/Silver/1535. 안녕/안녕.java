import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] stamina = new int[n+1];
        int[] delight = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            stamina[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            delight[i] = Integer.parseInt(st.nextToken());
        }

        final int initialStamina = 100;
        int[][] dp = new int[n+1][initialStamina];

        for(int i=1; i<=n; i++){
            for(int j=initialStamina-1; j>=0; j--){
                dp[i][j] = dp[i-1][j];
                if(j-stamina[i]>=0)
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-stamina[i]]+delight[i]);
            }
        }

        int answer = 0;
        for(int i=0; i<initialStamina; i++){
            answer = Math.max(answer, dp[n][i]);
        }

        System.out.println(answer);
    }
}
