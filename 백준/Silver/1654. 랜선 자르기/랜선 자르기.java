import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int max_value = Integer.MIN_VALUE;
        int[] arr = new int[K];
        for(int i=0; i<K; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max_value = Math.max(arr[i], max_value);
        }
        long lt = 1;
        long rt = max_value;
        long result = -1;
        while (lt<=rt){
            long mid = (lt+rt)/2;
            int cnt = 0;
            for(int i=0; i<K; i++){
                cnt += arr[i]/mid;
            }
            if(cnt<N){
                rt = mid-1;
            } else if (cnt>=N) {
                lt = mid+1;
                result = Math.max(result, mid);
            }
        }
        bw.write(String.valueOf(result));
        bw.close();
        br.close();
    }
}
