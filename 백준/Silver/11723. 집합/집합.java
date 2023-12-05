import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        int s = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String opr = st.nextToken();
            int x;
            switch (opr){
                case "add":
                    x = Integer.parseInt(st.nextToken())-1;
                    s |= 1<<x;
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken())-1;
                    s &= ~(1<<x);
                    break;
                case "check":
                    x = Integer.parseInt(st.nextToken())-1;
                    if((s & 1<<x) ==0)
                        sb.append(0 +"\n");
                    else
                        sb.append(1 + "\n");
                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken())-1;
                    s ^= 1<<x;
                    break;
                case "all":
                    s |= ~0;
                    break;
                case "empty":
                    s &= 0;
                    break;
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}