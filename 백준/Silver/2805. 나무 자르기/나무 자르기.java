import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int max_value = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max_value = Math.max(max_value, arr[i]);
        }

        int lt = 0;
        int rt = max_value-1;
        int result = Integer.MIN_VALUE;
        while (lt<=rt){
            int H = (lt+rt)/2;
            long sum = 0;
            for(int i=0; i<N; i++){
                if(arr[i]>H)
                    sum += arr[i]-H;
            }
            if(sum>=M){
                result = Math.max(H, result);
                lt = H+1;
            }
            else{
                rt = H-1;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
