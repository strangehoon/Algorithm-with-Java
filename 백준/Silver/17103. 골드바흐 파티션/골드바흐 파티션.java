import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.valueOf(br.readLine());
        // false : 소수 O, true : 소수 X
        boolean[] arr = new boolean[1000001];
        arr[1] = true;
        for(int i=2; i<=Math.sqrt(1000000); i++){
            if(!arr[i]) {
                for (int j = i + i; j <= 1000000; j += i) {
                    arr[j] = true;
                }
            }
        }

        while(T-->0){
            int N = Integer.valueOf(br.readLine());
            int cnt = 0;
            for(int i=2; i<=N/2; i++){
                if(arr[i]==false && arr[N-i]==false){
                    cnt++;
                }
            }
            bw.write(String.valueOf(cnt)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}