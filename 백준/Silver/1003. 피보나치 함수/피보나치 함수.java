import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            int N = Integer.parseInt(br.readLine());
            int[][] result = new int[N+1][2];
            result[0][0] = 1;
            result[0][1] = 0;
            if(N>0){
                result[1][0] = 0;
                result[1][1] = 1;
                for(int i=2; i<=N; i++){
                    result[i][0] = result[i-2][0] + result[i-1][0];
                    result[i][1] = result[i-2][1] + result[i-1][1];
                }
            }
            bw.write(String.valueOf(result[N][0] +" " + result[N][1] +"\n"));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}