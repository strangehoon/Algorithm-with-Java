import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        int cnt = 0;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i=0; i<N; i++){
            long x = arr[i];
            int j = 0;
            int k = N-1;
            long sum = arr[j] + arr[k];

            while (j<k){
                if(sum<x){
                    sum -= arr[j++];
                    sum += arr[j];
                } else if (sum==x) {
                    if(j==i && j<k){
                        sum -= arr[j++];
                        sum += arr[j];
                        continue;
                    }
                    if(k==i && j<k){
                        sum -= arr[k--];
                        sum += arr[k];
                        continue;
                    }
                    cnt++;
                    break;
                }
                else {
                    sum -= arr[k--];
                    sum += arr[k];
                }
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}