import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        int[] trace = new int[N+1];
        dp[1] = 0;
        for(int i=2; i<N+1; i++){
            dp[i] = dp[i-1]+1;
            trace[i] = i-1;
            if(i%2==0){
                if(dp[i]>dp[i/2]+1){
                    dp[i] = dp[i/2]+1;
                    trace[i] = i/2;
                }
            }
            if(i%3==0){
                if(dp[i]>dp[i/3]+1){
                    dp[i] = dp[i/3]+1;
                    trace[i] = i/3;
                }
            }
        }
        bw.write(String.valueOf(dp[N]) +"\n");
        bw.write(String.valueOf(N +" "));
        int cnt = dp[N];
        for(int i=0; i<cnt; i++){
            bw.write(String.valueOf(trace[N]+" "));
            N =trace[N];
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
