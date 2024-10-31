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
        dp[0] = 1;
        for(int i=1; i<N; i++){
            int max_value = 0;
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j]){
                    max_value = Math.max(max_value, dp[j]);
                }
            }
            dp[i] += max_value+1;
        }

        int maxResult = 0;
        for(int i=0; i<N; i++){
            maxResult = Math.max(maxResult, dp[i]);
        }
        bw.write(String.valueOf(maxResult));
        
        bw.flush();
        bw.close();
        br.close();
    }
}