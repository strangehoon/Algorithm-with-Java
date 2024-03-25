import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int result = 0;
    public static void Sol(int size, int r, int c){

        if(size==1){
            return;
        }

        int half = size/2;

        // 제 1사분면
        if(r < half && c < half){
            Sol(half, r, c);
        }

        // 제 2사분면
        else if (r < half && c >= half) {
            result += size*size/4;
            Sol(half, r, c-half);
        }

        // 제 3사분면
        else if (r >= half && c < half) {
            result += size*size/4*2;
            Sol(half, r-half, c);
        }

        // 제 4사분면
        else{
            result += size*size/4*3;
            Sol(half, r-half, c-half);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Sol((int)Math.pow(2,N), r, c);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}