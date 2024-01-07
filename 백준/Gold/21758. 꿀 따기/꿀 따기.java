import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        int[] pSum = new int[N+1];
        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            pSum[i] = pSum[i-1]+arr[i];
        }

        int max_value = Integer.MIN_VALUE;
        
        // case 1 : 벌-벌-벌통
        for(int i=2; i<N; i++){
            int result = 0;
            result += pSum[N]-arr[1]-arr[i];
            result += pSum[N]-pSum[i];
            max_value = Math.max(result, max_value);
        }
        
        // case 2 : 벌통-벌-벌
        for(int i=2; i<N; i++){
            int result = 0;
            result += pSum[N]-arr[N]-arr[i];
            result += pSum[i-1];
            max_value = Math.max(result, max_value);
        }
        
        // case 3 : 벌-벌통-벌
        for(int i=2; i<N; i++){
            int result = 0;
            result += pSum[i]-arr[1];
            result += pSum[N-1]-pSum[i-1];
            max_value = Math.max(result, max_value);
        }
        
        bw.write(String.valueOf(max_value));
        bw.flush();
        bw.close();
        br.close();
    }
}
