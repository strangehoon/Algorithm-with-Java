import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = 10;
        int sum = 0;
        int max_value = Integer.MIN_VALUE;
        while (cnt-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int get_out = Integer.parseInt(st.nextToken());
            int get_in = Integer.parseInt(st.nextToken());
            sum += (get_in-get_out);
            max_value = Math.max(max_value, sum);
        }
        bw.write(String.valueOf(max_value));
        bw.flush();
        bw.close();
        br.close();
    }
}