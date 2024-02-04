import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static long Solve(long A, long B, long C){
        if(B==0){
            return 1;
        }
        else {
            long tem = Solve(A, B/2, C);
            if(B%2==0){
                return tem*tem%C;
            }
            else {
                return tem*tem%C*A%C;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(Solve(A, B, C)));

        bw.flush();
        bw.close();
        br.close();
    }
}