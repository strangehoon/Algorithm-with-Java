import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1002];
        int lt = Integer.MAX_VALUE;
        int rt = Integer.MIN_VALUE;
        int max_height = Integer.MIN_VALUE;
        int max_height_pos = -1;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            arr[L] = H;
            lt = Math.min(lt, L);
            rt = Math.max(rt, L);
            if(max_height<H){
                max_height = H;
                max_height_pos = L;
            }
        }

        // 왼쪽 접근
        int std = 0;
        int sum = 0;
        for(int i=lt; i<max_height_pos; i++){
            if(arr[i]>std){
                std = arr[i];
            }
            sum += std;
        }

        //가운데(제일 높은 곳)
        sum += arr[max_height_pos];

        // 오른쪽 접근
        std = 0;
        for(int i=rt; i>max_height_pos; i--){
            if(arr[i]>std){
                std=arr[i];
            }
            sum += std;
        }

        System.out.println(sum);
    }
}