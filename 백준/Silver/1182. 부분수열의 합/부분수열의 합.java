import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;

    static int result, S, N;

    public static void DFS(int index, int sum, int cnt){
        if(index>=N){
            if(cnt!=0 && sum==S)
                result++;
        }
        else {
            DFS(index + 1, sum + arr[index], cnt + 1);
            DFS(index + 1, sum, cnt);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        DFS(0,0, 0);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
