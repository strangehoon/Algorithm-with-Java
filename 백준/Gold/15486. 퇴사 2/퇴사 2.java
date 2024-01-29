import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] result = new int[N+1];
        for(int i=1; i<N+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            result[i] = Math.max(result[i-1], result[i]);
            
            if(i+T-1<=N){
                result[i+T-1] = Math.max(result[i-1]+P, result[i+T-1]);
            }
        }

        bw.write(String.valueOf(result[N]));
        bw.flush();
        bw.close();
        br.close();
    }
}