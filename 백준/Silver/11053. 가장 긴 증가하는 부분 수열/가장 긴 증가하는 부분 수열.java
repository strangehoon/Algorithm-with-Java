import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max_value = 1;
        dp[0] = 1;
        for(int i=1; i<N; i++){
            int cnt = 0;
            for(int j=0; j<i; j++){
                if(arr[j]<arr[i]){
                    cnt = Math.max(dp[j], cnt);
                }
            }
            dp[i] = cnt+1;
            max_value = Math.max(max_value, dp[i]);
        }

        bw.write(String.valueOf(max_value));
        bw.flush();
        bw.close();
        br.close();
    }
}
