import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = N/5;
        boolean flag = false;
        for(int i=M; i>=0; i--) {
            int sum = i * 5;
            if ((N - sum) % 3 == 0) {
                bw.write(String.valueOf(i + (N - sum) / 3));
                flag = true;
                break;
            }
        }
        if(flag==false)
            bw.write(String.valueOf(-1));

        bw.flush();
        bw.close();
        br.close();
    }
}
