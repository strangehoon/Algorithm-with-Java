import java.io.*;
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i=0; i<str1.length(); i++){
            for(int j=0; j<str2.length(); j++){
                if(str1.charAt(i)==str2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else{
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }

        bw.write(String.valueOf(dp[str1.length()][str2.length()]));
        bw.flush();
        bw.close();
        br.close();
    }
}