import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.valueOf(st.nextToken());
        int N = Integer.valueOf(st.nextToken());
        // 소수 : false, 소수가 아니면 true
        boolean [] arr = new boolean[N+1];
        arr[1] = true;
        for(int i=2; i<=N; i++){
            for(int j=i+i; j<=N; j+=i){
                arr[j] = true;
            }
        }

        for(int i=M; i<=N; i++){
            if(!arr[i])
                bw.write(String.valueOf(i) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}