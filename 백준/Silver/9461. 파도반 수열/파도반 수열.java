import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            int N = Integer.parseInt(br.readLine());
            long[] arr = new long[100+1];
            arr[1] = 1;
            arr[2] = 1;
            arr[3] = 1;
            arr[4] = 2;
            for(int i= 5; i<=N; i++){
                arr[i] = arr[i-5]+arr[i-1];
            }
            bw.write(String.valueOf(arr[N])+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}