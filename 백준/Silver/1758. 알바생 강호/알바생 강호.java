import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine())+1;
        }

        Arrays.sort(arr, Collections.reverseOrder());
        long sum=0;
        int x = 1;
        for(int i=0; i<N; i++){
            if(arr[i]-x>0){
                sum += (arr[i]-x);
            }
            x++;
        }
        bw.write(String.valueOf(sum));

        bw.flush();
        bw.close();
        br.close();

    }
}
