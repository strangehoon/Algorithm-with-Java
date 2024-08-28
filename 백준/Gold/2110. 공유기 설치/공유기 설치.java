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
        int C = Integer.valueOf(st.nextToken());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.valueOf(br.readLine());
        }
        Arrays.sort(arr);
        int result = Integer.MIN_VALUE;
        int start = 1;
        int end = arr[N-1];
        while(start<=end){
            int mid = (start+end)/2;
            int cnt = 1;
            int tem = arr[0];
            for(int i=1; i<N; i++){
                if(arr[i]>=mid+tem){
                    cnt++;
                    tem = arr[i];
                }
            }
            if(cnt<C){
                end = mid-1;
            }
            else{
                start = mid+1;
                result = Math.max(result, mid);
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}