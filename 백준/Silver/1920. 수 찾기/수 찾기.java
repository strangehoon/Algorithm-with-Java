import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] Aarr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            Aarr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(Aarr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int x = Integer.parseInt(st.nextToken());
            int lt = 0;
            int rt = N-1;
            boolean flag = true;
            while (lt<=rt){
                int mid = (lt+rt)/2;
                if(x<Aarr[mid]){
                    rt = mid-1;
                } else if (x>Aarr[mid]) {
                    lt = mid+1;
                }
                else {
                    flag = false;
                    break;
                }
            }
            if(flag==false)
                bw.write(String.valueOf(1)+"\n");
            else
                bw.write(String.valueOf(0)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}