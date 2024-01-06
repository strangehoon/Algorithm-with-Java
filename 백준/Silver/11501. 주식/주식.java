import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for(int j=0; j<N; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int max = arr[N-1];
            long sum = 0;
            for(int j=N-2; j>-1; j--){
                if(arr[j]<max){
                    sum = sum-arr[j]+max;
                } else if (arr[j]>max) {
                    max = arr[j];
                }
            }
            bw.write(String.valueOf(sum+"\n"));

        }

        bw.flush();
        bw.close();
        br.close();
    }
}
