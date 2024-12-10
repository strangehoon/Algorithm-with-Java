import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        int L = Integer.valueOf(st.nextToken());

        int[] arr = new int[N+2];
        if(N!=0){
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                arr[i] = Integer.valueOf(st.nextToken());
            }
        }
        arr[N+1] = L;
        Arrays.sort(arr);

        int lt = 1;
        int rt = L-1;
        int result = Integer.MAX_VALUE;
        while (lt<=rt){
            int mid = (lt+rt)/2;
            int cnt = 0;
            for(int i=0; i<=N; i++){
                cnt += (arr[i+1]-arr[i]-1)/mid;
            }

            if(cnt>M){
                lt = mid+1;
            }
            else{
                result = Math.min(result, mid);
                rt = mid-1;
            }
        }
        System.out.println(result);
    }
}