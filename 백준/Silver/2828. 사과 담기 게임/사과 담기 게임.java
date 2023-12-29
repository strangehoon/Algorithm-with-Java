import java.io.*;
        import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int J = Integer.parseInt(br.readLine());
        int[] arr = new int[J];
        for(int i=0; i<J; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int lt = 1;
        int rt = lt+M-1;
        int result = 0;
        for(int i=0; i<J; i++){
            if(arr[i]>rt){
                result += arr[i]-rt;
                rt = arr[i];
                lt = arr[i]-M+1;
            } else if (arr[i]<lt) {
                result += lt-arr[i];
                lt = arr[i];
                rt = arr[i]+M-1;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}