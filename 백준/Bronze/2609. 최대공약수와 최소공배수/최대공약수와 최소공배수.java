import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int gcd(int n, int m){
        if(m==0)
            return n;
        return gcd(m, n%m);
    }
    public static int lcd(int n, int m, int gcd){
        return n*m/gcd;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int gcd = gcd(n, m);
        int lcd = lcd(n, m, gcd);

        bw.write(String.valueOf(gcd)+"\n");
        bw.write(String.valueOf(lcd));
        bw.flush();
        bw.close();
        br.close();
    }
}