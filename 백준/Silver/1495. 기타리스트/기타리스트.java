import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][] dp = new boolean[N+1][M+1];
        dp[0][S] = true;

        for(int i=0; i<N; i++){
            for(int j=0; j<=M; j++){
                if(dp[i][j]==true){
                    if(j-arr[i]>=0){
                        dp[i+1][j-arr[i]] = true;
                    }
                    if(j+arr[i]<=M){
                        dp[i+1][j+arr[i]] = true;
                    }
                }
            }
        }

        int max_result = Integer.MIN_VALUE;
        for(int j=0; j<=M; j++){
            if(dp[N][j]==true){
                max_result = Math.max(max_result, j);
            }
        }
        if(max_result == Integer.MIN_VALUE)
            bw.write(String.valueOf(-1));
        else
            bw.write(String.valueOf(max_result));

        bw.flush();
        bw.close();
        br.close();
    }
}