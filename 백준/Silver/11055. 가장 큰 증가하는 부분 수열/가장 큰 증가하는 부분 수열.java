import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        for(int i=0; i< N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max_value = arr[0];
        dp[0] = arr[0];
        for(int i=1; i<N; i++){
            int sum = 0;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    sum = Math.max(dp[j], sum);
                }
            }
            dp[i] = sum + arr[i];
            max_value = Math.max(dp[i], max_value);
        }


        bw.write(String.valueOf(max_value));

        bw.flush();
        bw.close();
        br.close();
    }
}
