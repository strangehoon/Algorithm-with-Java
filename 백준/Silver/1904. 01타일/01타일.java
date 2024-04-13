import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        if(N==1) {
            bw.write(String.valueOf(1));
        }
        else{
            int[] arr = new int[N+1];
            arr[1] = 1;
            arr[2] = 2;
            for(int i= 3; i<=N; i++){
                arr[i] = (arr[i-2] + arr[i-1])%15746;
            }
            bw.write(String.valueOf(arr[N]));
        }


        bw.flush();
        bw.close();
        br.close();
    }
}