import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] odd_prefix_sum = new int[H+2];
        int[] even_prefix_sum = new int[H+2];
        int[] odd_arr = new int[H+1];
        int[] even_arr = new int[H+1];
        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            if(i%2==0){
                even_arr[x]++;
            } else {
                odd_arr[H-x]++;
            }
        }

        for(int i=H; i>0; i--){
            even_prefix_sum[i] = even_prefix_sum[i+1] + even_arr[i];
        }
        for(int i=H; i>0; i--){
            odd_prefix_sum[i] = odd_prefix_sum[i+1] + odd_arr[i];
        }
        for(int i=H; i>0; i--){
            odd_prefix_sum[i] = N/2 - odd_prefix_sum[i];
        }

        int min_value = Integer.MAX_VALUE;
        int cnt = 0;
        for(int i=1; i<=H; i++){
            if(min_value>even_prefix_sum[i]+odd_prefix_sum[i]){
                min_value = even_prefix_sum[i]+odd_prefix_sum[i];
                cnt = 1;
            } else if (min_value == even_prefix_sum[i] + odd_prefix_sum[i]) {
                cnt++;
            }
        }
        bw.write(String.valueOf(min_value +" " + cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}