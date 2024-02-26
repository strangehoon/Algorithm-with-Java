import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        char[] chArr = str.toCharArray();
        int[] dp = new int[N];
        List<Character> alphaList = new ArrayList<>();
        alphaList.add('B');
        alphaList.add('O');
        alphaList.add('J');
        for(int i=0; i<N; i++){
            char alpha = chArr[i];
            char nextAlpha = alphaList.get((alphaList.indexOf(alpha)+1)%3);
            if(i!=0 && dp[i]==0)
                continue;
            for(int j=i+1; j<N; j++){
                if(chArr[j]==nextAlpha){
                    if(dp[j]==0)
                        dp[j] = (j-i)*(j-i) + dp[i];
                    else
                        dp[j] = Math.min(dp[j], (j-i)*(j-i) + dp[i]);
                }
            }
        }

        if (dp[N-1]==0 && N==1)
            bw.write(String.valueOf(0));
        else if(dp[N-1]==0)
            bw.write(String.valueOf(-1));
        else
            bw.write(String.valueOf(dp[N-1]));

        bw.flush();
        bw.close();
        br.close();
    }
}