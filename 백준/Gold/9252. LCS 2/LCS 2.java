import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int[][] dp;
    public static String str1;
    public static String str2;
    public static List<Character> list = new ArrayList<>();
    public static void Recur(int n, int m){

        if(n==0 || m==0){
            return;
        }

        if(str2.charAt(n-1)==str1.charAt(m-1)){
            list.add(str1.charAt(m-1));
            Recur(n-1, m-1);
        }
        else{
            if(dp[n-1][m]<dp[n][m-1]){
                Recur(n, m-1);
            }
            else{
                Recur(n-1, m);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str1 = br.readLine();
        str2 = br.readLine();

        dp = new int[str2.length()+1][str1.length()+1];

        for(int i=1; i<=str2.length(); i++){
            for(int j=1; j<=str1.length(); j++){
                if(str1.charAt(j-1)==str2.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[str2.length()][str1.length()]);
        Recur(str2.length(), str1.length());

        StringBuilder sb = new StringBuilder();
        for(int i=list.size()-1; i>=0; i--){
            sb.append(list.get(i));
        }
        System.out.println(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}