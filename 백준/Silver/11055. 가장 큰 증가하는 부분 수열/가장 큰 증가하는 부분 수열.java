import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j])
                    dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i] += arr[i];
        }

        int result = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            result = Math.max(result, dp[i]);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}