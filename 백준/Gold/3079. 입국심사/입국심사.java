import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.valueOf(br.readLine());
        }

        long lt = 1;
        long rt = 1000000000000000000l;
        long result = 1000000000000000000l;
        while (lt<=rt){
            long mid = (lt+rt)/2;
            long cnt = 0;
            for(int i=0; i<N; i++){
                cnt += mid/arr[i];
                if(cnt>=M)
                    break;
            }

            if(cnt>=M){
                rt = mid-1;
                result = Math.min(result, mid);
            }
            else if(cnt<M){
                lt = mid+1;
            }
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }
}