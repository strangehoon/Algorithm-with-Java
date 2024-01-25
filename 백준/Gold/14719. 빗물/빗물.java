import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] arr = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<W; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int left_max_height = arr[0];
        for(int i=1; i<W-1; i++){
            int right_max_height = arr[i];
            for(int j=0; j<i; j++){
                left_max_height = Math.max(left_max_height, arr[j]);
            }
            for(int j=i+1; j<W; j++){
                right_max_height = Math.max(right_max_height, arr[j]);
            }

            int std = Math.min(left_max_height, right_max_height);
            if(std-arr[i]>0){
                result += std-arr[i];
            }
        }
        System.out.println(result);
    }
}