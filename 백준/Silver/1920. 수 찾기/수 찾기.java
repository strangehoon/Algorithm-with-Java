import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int tem = Integer.parseInt(st.nextToken());
            int j=0;
            int k = N-1;
            boolean flag = false;
            while (j<=k){
                int mid = (j+k)/2;
                if(arr[mid]<tem)
                    j = mid+1;
                else if (arr[mid]>tem) 
                    k = mid-1;
                else {
                    flag = true;
                    break;
                }
            }
            bw.write(String.valueOf(flag == false ? 0 : 1)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}