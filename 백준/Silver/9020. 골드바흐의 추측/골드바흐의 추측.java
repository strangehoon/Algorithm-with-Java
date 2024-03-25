import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        arr[1] = 1;
        for(int i=2; i<=10000; i++){
            if(arr[i]==0){
                for(int j=i+i; j<= 10000; j += i){
                    arr[j] = 1;
                }
            }
        }

        while (T-->0){
            int n = Integer.parseInt(br.readLine());
            for(int i=n/2; i>= 2; i--){
                if(arr[i]==0 && arr[n-i]==0){
                    bw.write(String.valueOf(i) + ' ' +  String.valueOf(n-i)+"\n");
                    break;
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}