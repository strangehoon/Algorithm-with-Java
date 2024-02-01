import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static class Pos implements Comparable<Pos>{
        int x;
        int y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pos o) {
            if(this.x==o.x){
                return this.y-o.y;
            }
            else {
                return this.x-o.x;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Pos[] arr = new Pos[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Pos(x, y);
        }
        Arrays.sort(arr);
        for(int i=0; i<N; i++){
            bw.write(String.valueOf(arr[i].x) +" " + String.valueOf(arr[i].y) +"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}