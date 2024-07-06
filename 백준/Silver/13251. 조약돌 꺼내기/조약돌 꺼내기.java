import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.valueOf(st.nextToken());
        int[] arr = new int[M];
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int tem = Integer.valueOf(st.nextToken());
            arr[i] = tem;
            sum += tem;
        }
        st = new StringTokenizer(br.readLine());
        int K = Integer.valueOf(st.nextToken());

        double result = 0;
        for(int i=0; i<M; i++){
            double tem = 1.0;
            int tem_sum = sum;
            int num = arr[i];
            for(int j=0; j<K; j++){
                tem *= (double)num--/(double)tem_sum--;
            }
            result += tem;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}