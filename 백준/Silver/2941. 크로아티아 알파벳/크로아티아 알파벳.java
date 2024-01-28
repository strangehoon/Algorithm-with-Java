import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String[] croatias = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for(int i=0; i<8; i++){
            str=str.replaceAll(croatias[i], "*");
        }
        bw.write(String.valueOf(str.length()));
        bw.flush();
        bw.close();
        br.close();
    }
}