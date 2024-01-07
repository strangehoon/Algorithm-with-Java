import java.io.*;
public class Main {
    static int cnt, N;
    public static void DFS(int sum){
        for(int i=1; i<=3; i++){
            if(sum+i<N){
                DFS(sum+i);
            } else if (sum+i==N) {
                cnt++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            N = Integer.parseInt(br.readLine());
            cnt = 0;
            DFS(0);
            bw.write(String.valueOf(cnt)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}