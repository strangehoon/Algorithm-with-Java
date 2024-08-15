import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.valueOf(br.readLine());
        }
        Arrays.sort(arr);
        int i=0;
        int j=0;
        int tem;
        int min_value = Integer.MAX_VALUE;
        while(i<N){
            tem = arr[i]-arr[j];
            if(tem<M){
                i++;
            }
            else if(tem>M){
                min_value = Math.min(min_value, tem);
                j++;
            }
            else{
                min_value = Math.min(min_value, tem);
                i++;
            }
        }
        bw.write(String.valueOf(min_value));
        bw.flush();
        bw.close();
        br.close();
    }
}