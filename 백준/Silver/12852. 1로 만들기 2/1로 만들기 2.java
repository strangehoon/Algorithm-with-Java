import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        String[] strArr = new String[N+1];
        dp[1] = 0;
        strArr[1] = new String("1");
        for(int i=2; i<N+1; i++){
            dp[i] = dp[i-1]+1;
            int flag = 1;
            if(i%2==0){
                if(dp[i]>dp[i/2]+1){
                    dp[i] = dp[i/2]+1;
                    flag = 2;
                }
            }
            if(i%3==0){
                if(dp[i]>dp[i/3]+1){
                    dp[i] = dp[i/3]+1;
                    flag = 3;
                }
            }
            if(flag ==1){
                strArr[i] = i+" " + strArr[i-1];
            } else if (flag==2) {
                strArr[i] = i +" " + strArr[i/2];
            }
            else
                strArr[i] = i+" " + strArr[i/3];
        }
        bw.write(String.valueOf(dp[N]) +"\n");
        bw.write(String.valueOf(strArr[N]));
        bw.flush();
        bw.close();
        br.close();
    }
}
