import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int init_get_out = Integer.parseInt(st.nextToken());
        int init_get_in = Integer.parseInt(st.nextToken());
        int max_value = init_get_in-init_get_out;
        int sum = init_get_in-init_get_out;
        int cnt = 9;
        while (cnt-->0){
            st = new StringTokenizer(br.readLine());
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