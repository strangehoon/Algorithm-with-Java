import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n+1];
            dp[0] = 1;
            for(int j=1; j<=n; j++){
                if(j-3>=0){
                    dp[j] += dp[j-3]; 
                }
                if (j-2>=0) {
                    dp[j] += dp[j-2];
                }
                if(j-1>=0){
                    dp[j] += dp[j-1];
                }
            }
            bw.write(String.valueOf(dp[n])+"\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}