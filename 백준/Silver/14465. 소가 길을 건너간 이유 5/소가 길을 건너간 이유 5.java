import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[N+1];
        for(int i=0; i<B; i++){
            int x = Integer.parseInt(br.readLine());
            arr[x] = true;
        }

        int cnt = 0;
        for(int i=1; i<=K; i++){
            if(arr[i]==true)
                cnt++;
        }
        int min_value = cnt;
        for(int i=K+1; i<=N; i++){
            if(arr[i]==true){
                cnt++;
            }
            if(arr[i-K]==true){
                cnt--;
            }
            min_value = Math.min(cnt, min_value);
        }

        bw.write(String.valueOf(min_value));

        bw.flush();
        bw.close();
        br.close();
    }
}
