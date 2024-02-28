import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int i=0;
        int j=N-1;
        int a = arr[i];
        int b = arr[j];
        int min_value = Integer.MAX_VALUE;
        while (i<j){
            int sum = Math.abs(arr[i] + arr[j]);
            int abs_a = Math.abs(arr[i]);
            int abs_b = Math.abs(arr[j]);
            if(min_value<sum){
                if(abs_a<=abs_b)
                    j--;
                else
                    i++;
            }
            else if (min_value>=sum) {
                min_value = sum;
                a = arr[i];
                b = arr[j];
                if(abs_a<=abs_b)
                    j--;
                else
                    i++;
            }
        }
        bw.write(String.valueOf(a +" " + b));
        bw.flush();
        bw.close();
        br.close();
    }
}