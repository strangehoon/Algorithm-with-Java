import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 물품 수
        int K = Integer.parseInt(st.nextToken()); // 배낭 용량

        // 입력 값 검증
        if (N <= 0 || K <= 0) {
            System.out.println(0);
            return;
        }

        int[] dp = new int[K + 1]; // DP 배열 초기화
        
        // 물품 정보 입력 및 DP 갱신
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken()); // 물건의 무게
            int value = Integer.parseInt(st.nextToken());  // 물건의 가치

            // 역순으로 DP 배열 갱신
            for (int j = K; j >= weight; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight] + value);
            }
        }

        // 최종 결과 출력
        System.out.println(dp[K]);
    }
}