import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        int max = Integer.MIN_VALUE;
        int pos = 0;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a]=b;
            if(max<b){
                max = b;
                pos = a;
            }
        }

        int sum = 0;
        int height = arr[0];
        for(int i=1; i<=pos; i++){
            sum += height;
            if(i==pos)
                break;
            else if (arr[i]>height) {
                height = arr[i];
            }
        }

        height = arr[1000];
        boolean flag = true;
        for(int i= 1000; i>=pos; i--){
            if(height<arr[i]){
                height = arr[i];
            }
            sum += height;

        }

        bw.write(String.valueOf(sum));

        bw.flush();
        bw.close();
        br.close();
    }
}
