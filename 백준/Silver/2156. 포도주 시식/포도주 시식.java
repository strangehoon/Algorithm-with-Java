import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10000];
        int[] dp = new int[10000];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = arr[0];
        dp[1] = arr[0]+arr[1];
        dp[2] = Math.max(arr[0]+arr[2], arr[1]+arr[2]);
        dp[2] = Math.max(arr[0]+arr[1], dp[2]);
        for(int i=3; i<n; i++){
            int tem = Math.max(dp[i-3]+arr[i-1]+arr[i], dp[i-2]+arr[i]);
            dp[i] = Math.max(tem, dp[i-1]);
        }

        bw.write(String.valueOf(dp[n-1]));

        bw.close();
        br.close();
    }
}
