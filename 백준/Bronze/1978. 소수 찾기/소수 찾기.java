import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        for(int i=0; i<N; i++){
            boolean flag = true;
            int x = arr[i];
            if(x==1){
                flag = false;
            }
            else {
                for(int j=2; j<=Math.sqrt(x); j++){
                    if(x%j==0){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag==true){
                cnt++;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}