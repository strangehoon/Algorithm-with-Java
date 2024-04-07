import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            double dist = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
            if(x1==x2 && y1==y2 && r1==r2)
                bw.write(String.valueOf(-1)+"\n");
            else if (Math.abs(r1-r2)==dist)
                bw.write(String.valueOf(1)+"\n");
            else if (Math.abs(r1-r2)>dist) {
                bw.write(String.valueOf(0)+"\n");
            } else if (r1+r2==dist)
                bw.write(String.valueOf(1)+"\n");
            else if (r1+r2>dist)
                bw.write(String.valueOf(2)+"\n");

            else if (r1+r2<dist)
                bw.write(String.valueOf(0)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}