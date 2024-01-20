import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int max_value = Integer.MIN_VALUE;
        int min_value = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max_value = Math.max(max_value, arr[i]);
            min_value = Math.min(min_value, arr[i]);
        }

        bw.write(String.valueOf(min_value+" " + max_value));
        bw.flush();
        bw.close();
        br.close();
    }
}