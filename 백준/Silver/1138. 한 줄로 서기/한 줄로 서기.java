import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = -1;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++){
            int x = Integer.parseInt(st.nextToken());
            for(int j=0; j<N; j++){
                if(arr[j]==-1) {
                    if(x==0){
                        arr[j] = i;
                        break;
                    }
                    else
                        x--;
                }
            }
        }

        for(int i=0; i<N; i++){
            bw.write(String.valueOf(arr[i] +" "));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
