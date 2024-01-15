import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] pi = new int[N];
        for(int i=0; i<N; i++){
            pi[i] = Integer.parseInt(st.nextToken());
        }
        
        // sol
        Arrays.sort(pi);
        int[] time = new int[N];
        time[0] = pi[0];
        int answer = 0;
        answer += time[0];
        for(int i=1; i<N; i++) {
            time[i] = time[i - 1] + pi[i];
            answer += time[i];
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}