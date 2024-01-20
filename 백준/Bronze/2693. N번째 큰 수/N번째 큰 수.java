import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            Integer[] arr = new Integer[10];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<10; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr, Collections.reverseOrder());
            bw.write(String.valueOf(arr[2])+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}