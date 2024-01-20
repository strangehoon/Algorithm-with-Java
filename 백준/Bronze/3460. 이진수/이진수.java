import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;
            while (true){
                if(n%2==1){
                    bw.write(String.valueOf(cnt+" "));
                }
                n /= 2;
                cnt++;
                if(n==0)
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}