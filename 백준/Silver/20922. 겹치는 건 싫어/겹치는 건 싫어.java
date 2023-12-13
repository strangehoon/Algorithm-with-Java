import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());

        int[] arr = new int[N];
        int[] cnt = new int[100001];
        int len = Integer.MIN_VALUE;
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        int j=0;

        for(int i=0; i<N; i++){
            cnt[arr[i]] += 1;
            if(cnt[arr[i]]>K){
                while (true){
                    cnt[arr[j]] -= 1;
                    if(arr[j]==arr[i]){
                        j++;
                        break;
                    }
                    j++;
                }
            }
            len = Math.max(len,i-j+1);
        }
        bw.write(String.valueOf(len));
        bw.flush();
        bw.close();
        br.close();
    }
}
