import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] arr = new long[N+1];
        long[] prefix_sum = new long[N+1];
        long[] trans = new long[M];
        long result = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<N+1; i++){
            prefix_sum[i] = prefix_sum[i-1] + arr[i];
        }

        for(int i=0; i<N+1; i++){
            prefix_sum[i] %= M;
            trans[(int) prefix_sum[i]] += 1;
        }

        for(int i=0; i<M; i++){
            result += trans[i]*(trans[i]-1)/2;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}