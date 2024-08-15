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
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }

        boolean[][] dp = new boolean[N][N];

        // 1자리 수
        for(int i=0; i<N; i++){
            dp[i][i] = true;
        }

        // 2자리 수
        for(int i=0; i<N-1; i++){
            if(arr[i]==arr[i+1]){
                dp[i][i+1]=true;
            }
        }

        // 3자리 이상
        for(int i=2; i<N; i++){
            for(int j=0; j<i-1; j++){
                if(arr[i]==arr[j]){
                    dp[j][i] = dp[j+1][i-1];
                }
            }
        }

        int M = Integer.valueOf(br.readLine());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.valueOf(st.nextToken());
            int E = Integer.valueOf(st.nextToken());
            if(dp[S-1][E-1])
                bw.write("1\n");
            else
                bw.write("0\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}