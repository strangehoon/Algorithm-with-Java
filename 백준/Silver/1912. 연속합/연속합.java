import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] pSum = new int[n+1];
        for(int i=1; i<n+1; i++){
            int x = Integer.parseInt(st.nextToken());
            pSum[i] = pSum[i-1]+x;
        }

        int min_value = 0;
        int max_value = Integer.MIN_VALUE;
        for(int i=1; i<n+1; i++){
            max_value = Math.max(max_value, pSum[i]-min_value);
            if(min_value>pSum[i]){
                min_value = pSum[i];
            }
        }

        bw.write(String.valueOf(max_value));
        bw.flush();
        bw.close();
        br.close();
    }
}
