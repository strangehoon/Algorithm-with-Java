import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int i = 0;
        int j = N-1;
        int cnt = 0;
        int sum = arr[i]+arr[j];
        while (i<j){
            if(sum<M){
                sum -= arr[i++];
                sum += arr[i];
            }
            else if (sum == M) {
                sum -= arr[i++];
                sum += arr[i];
                cnt++;
            }
            else {
                sum -= arr[j--];
                sum += arr[j];
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}