import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] cost = new int[N];
        int[] gain = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            gain[i] = Integer.parseInt(st.nextToken());
        }

        final int EXTRA = 100;               // gain의 최댓값이 100
        int LIMIT = C + EXTRA;               // C를 넘어도 달성 가능
        int INF = 1_000_000_000;

        int[] dp = new int[LIMIT + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        // 무제한 배낭: 아이템(도시) 밖 루프, 안에서 x를 증가 방향으로
        for (int i = 0; i < N; i++) {
            for (int x = gain[i]; x <= LIMIT; x++) {
                if (dp[x - gain[i]] != INF) {
                    dp[x] = Math.min(dp[x], dp[x - gain[i]] + cost[i]);
                }
            }
        }

        int ans = INF;
        for (int x = C; x <= LIMIT; x++) ans = Math.min(ans, dp[x]);
        System.out.println(ans);
    }
}