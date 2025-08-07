import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "0" + br.readLine();
        int len = str.length();
        int[] dp = new int[len];
        dp[0] = 1;
        if(str.charAt(1)=='0') {
            System.out.println(0);
            return;
        }
        dp[1] = 1;

        for(int i=2; i<len; i++){
            int tem = Integer.valueOf(str.substring(i-1, i+1));

            if(tem==10 || tem==20){
                dp[i] = dp[i-2];
            }
            else if(11<=tem && tem<=26){
                dp[i] = (dp[i-1] + dp[i-2])%1000000;
            }
            else if(tem%10==0){
                System.out.println("0");
                return;
            }
            else {
                dp[i] = dp[i-1];
            }
        }

        System.out.println(dp[len-1]);
    }
}