import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int k = Integer.valueOf(st.nextToken());

        long lt = 1;
        long rt = k;
        long result = Integer.MAX_VALUE;
        while(lt<=rt){
            long mid = (lt+rt)/2;

            int tem = 0;
            for(int i=1; i<=N; i++){
                tem += Math.min(mid/i, N);
            }
            if(tem<k)
                lt = mid+1;
            else{
                rt = mid-1;
                result = Math.min(mid, result);
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}