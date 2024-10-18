import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        int[] arr = new int[N];
        int[] leftDp = new int[N];
        int[] rightDp = new int[N];

        for(int i=0; i<N; i++){
            leftDp[i] = 1;
            rightDp[i] = 1;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }

        for(int i=1; i<N; i++){
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j]){
                    leftDp[i] = Math.max(leftDp[i], leftDp[j]+1);
                }
            }
        }

        for(int i=N-2; i>=0; i--){
            for(int j=N-1; j>i; j--){
                if(arr[i]>arr[j]){
                    rightDp[i] = Math.max(rightDp[i], rightDp[j]+1);
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            answer = Math.max(answer, leftDp[i]+rightDp[i]-1);
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}