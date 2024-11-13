import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        int[] arr = new int[N];
        String[] strDP = new String[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }

        for(int i=0; i<N; i++){
            int max_value = 0;
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j]) {
                    if(max_value<dp[j]){
                        max_value = dp[j];
                        sb.setLength(0);
                        sb.append(strDP[j]);
                    }
                }
            }
            dp[i] = max_value+1;
            if(i==0)
                strDP[i] = "" + arr[i];
            else
                strDP[i] = sb.toString() + " " + arr[i];
        }

        int max_idx = 0;
        int max_len = 0;
        for(int i=0; i<N; i++){
            if(max_len<dp[i]){
                max_idx = i;
                max_len = dp[i];
            }
        }

        bw.write(String.valueOf(max_len)+"\n");
        bw.write(strDP[max_idx]);

        bw.flush();
        bw.close();
        br.close();
    }
}