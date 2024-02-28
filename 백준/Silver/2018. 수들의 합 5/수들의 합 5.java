import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = i;
        }
        int sum = 1;
        int cnt = 1;
        int i=1;
        int j=1;
        while(i<N){
            if(sum<N){
                i++;
                sum += arr[i];
            }
            else if (sum==N) {
                i++;
                sum += arr[i];
                cnt++;
            }
            else{
                sum -= arr[j];
                j++;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}