import java.io.*;
import java.util.StringTokenizer;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int end = 0;
        int max_value = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            end += arr[i];
            max_value = Math.max(max_value, arr[i]);
        }

        int lt = max_value;
        int rt = end;
        while (lt<=rt){
            int mid = (lt+rt)/2;
            int sum = 0;
            int cnt = 0;
            for(int k=0; k<N; k++){
                if(sum+arr[k]>mid){
                    cnt++;
                    sum = 0;
                }
                sum += arr[k];
            }
            if(sum!=0)
                cnt++;
            if(cnt <= M)
                rt = mid-1;
            else
                lt = mid+1;
        }

        bw.write(String.valueOf(lt));

        bw.flush();
        bw.close();
        br.close();
    }
}