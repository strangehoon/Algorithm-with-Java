import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int j=0;
        int i=0;
        int min_value = Integer.MAX_VALUE;
        int sum=arr[i];
        while (j<N &&i<N){
            if(sum<S && i<N-1){
                sum+=arr[++i];
            }
            else if(sum>=S){
                if(i-j+1!=0)
                    min_value = Math.min(i-j+1, min_value);
                sum-=arr[j++];
            }
            else
                break;
        }
        if(min_value==Integer.MAX_VALUE)
            bw.write(String.valueOf(0));
        else
            bw.write(String.valueOf(min_value));
        bw.flush();
        bw.close();
        br.close();
    }
}