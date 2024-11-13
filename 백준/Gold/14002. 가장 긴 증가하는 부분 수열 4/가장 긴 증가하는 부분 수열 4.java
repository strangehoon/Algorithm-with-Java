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
        int[] arr = new int[N+1];
        int[] parent = new int[N+1];
        int[] dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            int max_value = 0;
            for(int j=1; j<i; j++){
                if(arr[i]>arr[j]) {
                    if(max_value<dp[j]){
                        max_value = dp[j];
                        parent[i] = j;
                    }
                }
            }
            dp[i] = max_value+1;
        }

        int max_idx = 0;
        int max_len = 0;
        for(int i=1; i<=N; i++){
            if(max_len<dp[i]){
                max_idx = i;
                max_len = dp[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        while(true){
            if(parent[max_idx]!=max_idx){
                sb.insert(0, arr[max_idx]+" ");
                max_idx = parent[max_idx];
            }
            else{
                break;
            }
        }

        bw.write(String.valueOf(max_len)+"\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}