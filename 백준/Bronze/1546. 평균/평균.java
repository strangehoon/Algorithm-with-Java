import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        double[] dArr = new double[N];
        int M = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            arr[i] = Integer.valueOf(st.nextToken());
            M = Math.max(M, arr[i]);
        }
        double sum = 0;
        for(int i=0; i<N; i++){
            dArr[i] = (double)arr[i]/M*100;
            sum += dArr[i];
        }
        bw.write(String.valueOf(sum/N));

        bw.flush();
        bw.close();
        br.close();
    }
}